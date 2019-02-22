/*

 * 작성일 : 2019. 2. 20.

 * 작성자 : meta 전임 임정욱

 *

 * 설명   : 
 * 첨부된 로그파일을 분석하여 두 개의 결과 파일을 만드는 프로그램 개발
 * [파일 1] 로그 분석 방법으로 데이터를 로그에서 추출하여 시작 로그 순으로 파일 출력
 *  - 파일포맷: 17.07.11 23:28:57, 17.07.11 23:29:08, IF_1001_01_48fb51f9-ad8c-4fd6-824f-79009d8cc149, 110923, 9459, 00000, 00002, 09515, 00932
 *  로그 분석 방법

  - 로그에서 아래 그림의 순서대로 추출 키워드를 필터링하여 데이터 추출

  - 쓰레드명으로 같은 로그를 구분하여 데이터 추출

  - 추출 데이터가 완벽하게 없는 로그는 무시

 */




package logFileAnalysis;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.FileChooserUI;

/**

 * @author meta

 *

 ***************************************

 *     코드 수정 히스토리

 *  날짜          작업자         태그

 *2019. 2. 20.  meta  전임 임정욱

 ***************************************

 */
public class LogFileReader {
	
//	public String subList(int start,int end) {
//		String returnData = null;
//		for (int i = start; i < end ; i++) {
//		
//		}
//		return returnData;
//	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
//		long start = System.currentTimeMillis();
		Path pa = FileSystems.getDefault().getPath("C:\\galileo.log");
		try {
		List logList =Files.readAllLines(pa);
		ListIterator<String> itList = logList.listIterator();
//		while(itList.hasNext()){
//			System.out.println(itList.next());
//		}
		
//		long start = System.currentTimeMillis();
		Map<String, Object> threadMap = new HashMap<String,Object>();
		
		String logStartReg = "[\\[]([0-9][0-9].[0-9][0-9].[0-9][0-9][\\s][0-9][0-9]:[0-9][0-9]:[0-9][0-9])[\\]][\\s].*thread-(.*?)galileo.*?bean start\\.";
		Pattern logStartPT = Pattern.compile(logStartReg);
		
		String logEndReg = "[\\[]([0-9][0-9].[0-9][0-9].[0-9][0-9][\\s][0-9][0-9]:[0-9][0-9]:[0-9][0-9])[\\]][\\s].*thread-(.*?)galileo.*?bean end\\.";
		Pattern logEndPT = Pattern.compile(logEndReg);
		
		String logLengthReg = "thread-(.*?)galileo.*?(ESB_TRAN_ID)[\\s]:[\\s](.*)";
		Pattern logLengthPT = Pattern.compile(logLengthReg);
		
		String logCalltimeReg = "thread-(.*?)galileo.*?[\\#](galileo[\\s]call[\\s]time):(.*)";
		Pattern logCalltimePT = Pattern.compile(logCalltimeReg);
		
		String logStopWatchReg = "thread-(.*?)galileo.*?(StopWatch)(.*)";
		Pattern logStopWatchPT = Pattern.compile(logStopWatchReg);
		
		String logRunTimeReg = "((^([^\\[]|\\d)\\d\\d\\d\\d).*)";
		Pattern logRunTimePT = Pattern.compile(logRunTimeReg);
//		String parseLogReg2 = "(StopWatch ([\\s\\S])*?([\\[]JSSESION_ID){1}.*?([\n]))";
//		Pattern parsePT2 = Pattern.compile(parseLogReg);
		int count = 0;
		while(itList.hasNext()) {
			String logLine = itList.next();
		
			Matcher  matcher = logStartPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(2);
				String startTime = matcher.group(1);
				if(threadMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)threadMap.get(threadId)).clear();
					((HashMap)threadMap.get(threadId)).put("startTime", startTime);
//					System.out.println("start 두번"+threadMap.get(threadId));
				}else {
					threadMap.put(threadId, new HashMap<String,Object>());
					((HashMap)threadMap.get(threadId)).put("startTime", startTime);
//					System.out.println("start 한번"+threadMap.get(threadId));
				}
				continue;
			}
			
			matcher = logEndPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(2);
				String endTime = matcher.group(1);
				if(threadMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)threadMap.get(threadId)).put("endTime", endTime);
					
					if(((HashMap)threadMap.get(threadId)).size()==8) {
						count++;
					System.out.println(count+"끝남"+threadMap.get(threadId));
					}
					threadMap.remove(threadId);
				}
				continue;
			}
			
			matcher = logLengthPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(1);
				String contentLength = matcher.group(3);
				if(threadMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)threadMap.get(threadId)).put("contentLength", contentLength);
//					System.out.println("start 두번"+threadMap.get(threadId));
				}
				continue;
			}
			
			matcher = logCalltimePT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(1);
				String callTime = matcher.group(3);
				if(threadMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)threadMap.get(threadId)).put("callTime", callTime);
//					System.out.println("start 두번"+threadMap.get(threadId));
				}
				continue;
			}
			
			matcher = logCalltimePT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(1);
				String callTime = matcher.group(3);
				if(threadMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)threadMap.get(threadId)).put("callTime", callTime);
//					System.out.println("start 두번"+threadMap.get(threadId));
				}
				continue;
			}
			
			matcher = logStopWatchPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(1);
				if(threadMap.containsKey(threadId)) {
					int nextIdx = itList.nextIndex();
					System.out.println(nextIdx);
					System.out.println((String)(logList.get(nextIdx+3)));
					matcher = logRunTimePT.matcher((String)(logList.get(nextIdx+3)));
					if(matcher.find()) {
						((HashMap)threadMap.get(threadId)).put("beforeMarshalling", matcher.group(2));
					}
					matcher = logRunTimePT.matcher((String)(logList.get(nextIdx+4)));
					if(matcher.find()) {
						((HashMap)threadMap.get(threadId)).put("marshalling", matcher.group(2));
					}
					matcher = logRunTimePT.matcher((String)(logList.get(nextIdx+5)));
					if(matcher.find()) {
						((HashMap)threadMap.get(threadId)).put("invokingGalileo", matcher.group(2));
					}
					matcher = logRunTimePT.matcher((String)(logList.get(nextIdx+6)));
					if(matcher.find()) {
						((HashMap)threadMap.get(threadId)).put("unmarshallingAndSendToCmmmodServer", matcher.group(2));
					}
					continue;
				}
				continue;
			}
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
//		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0);
		
//		
	}

}

