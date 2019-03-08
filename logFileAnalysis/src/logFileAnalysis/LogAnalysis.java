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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
public class LogAnalysis {
	private String filePath = null; //파일 경로
	private HashMap<String, Object> tempMap = new HashMap<String,Object>();
	private HashMap<String, Object> threadMap = new HashMap<String,Object>();
	private List<String> logList = null;
	private ListIterator<String> itList = null;
	private List<String >outputList = new ArrayList<String>();
//	public String subList(int start,int end) {
//		String returnData = null;
//		for (int i = start; i < end ; i++) {
//		
//		}
//		return returnData;
//	}
	
	protected HashMap<String, Object> getByMap() {
		return this.threadMap;
	}
	protected List<String > getByList() {
		return this.outputList;
	}
	protected List<String > getBySortedList() {
		Collections.sort(outputList);
		return this.outputList;
	}
	
	protected HashMap<String, Object> logAnalysis(List<String> logList) {
		System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
		System.gc();
		long preUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long start = System.currentTimeMillis();
		
		
		String logStartReg = "[\\[]([\\d][\\d].[\\d][\\d].[\\d][\\d][\\s][\\d][\\d]:[\\d][\\d]:[\\d][\\d])[\\]][\\s].*thread-(.*?)galileo.*?bean start\\.";
		Pattern logStartPT = Pattern.compile(logStartReg);
		
		String logEndReg = "[\\[]([\\d][\\d].[\\d][\\d].[\\d][\\d][\\s][\\d][\\d]:[\\d][\\d]:[\\d][\\d])[\\]][\\s].*thread-(.*?)galileo.*?bean end\\.";
		Pattern logEndPT = Pattern.compile(logEndReg);
		
		String logTranIdReg = "thread-(.*?)galileo.*?(ESB_TRAN_ID)[\\s]:[\\s](.*)";
		Pattern logTranIdPT = Pattern.compile(logTranIdReg);
		
		String logLengthReg = "thread-(.*?)galileo.*?(Content\\-Length):(.*)";
		Pattern logLengthPT = Pattern.compile(logLengthReg);
		
		String logCalltimeReg = "thread-(.*?)galileo.*?[\\#](galileo[\\s]call[\\s]time):(.*?)[\\s]ms";
		Pattern logCalltimePT = Pattern.compile(logCalltimeReg);
		
		String logStopWatchReg = "thread-(.*?)galileo.*?(StopWatch)(.*)";
		Pattern logStopWatchPT = Pattern.compile(logStopWatchReg);
		
		String logRunTimeReg = "((^([^\\[]|\\d)\\d\\d\\d\\d).*)";
		Pattern logRunTimePT = Pattern.compile(logRunTimeReg);
		
		itList = logList.listIterator();
		int count = 0;
		while(itList.hasNext()) {
			String logLine = itList.next();
		
			Matcher  matcher = logStartPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(2);
				String startTime = matcher.group(1);
				if(tempMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)tempMap.get(threadId)).clear();
					((HashMap)tempMap.get(threadId)).put("startTime", startTime);
//					System.out.println("start 두번"+tempMap.get(threadId));
				}else {
					tempMap.put(threadId, new HashMap<String,Object>());
					((HashMap)tempMap.get(threadId)).put("startTime", startTime);
//					System.out.println("start 한번"+tempMap.get(threadId));
				}
				continue;
			}
			ArrayList<String> tempList = new ArrayList();
			matcher = logEndPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(2);
				String endTime = matcher.group(1);
				if(tempMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					HashMap targetMap = ((HashMap)tempMap.get(threadId));
					targetMap.put("endTime", endTime);
					
					if(((HashMap)tempMap.get(threadId)).size()==9) {
						count++;
						threadMap.put((((HashMap)tempMap.get(threadId)).get("esbTranId")).toString(),targetMap.get(threadId));
						
						tempList.add(targetMap.get("startTime").toString());
						tempList.add(targetMap.get("endTime").toString());
						tempList.add(targetMap.get("esbTranId").toString());
						tempList.add(targetMap.get("contentLength").toString());
						tempList.add(targetMap.get("callTime").toString());
						tempList.add(targetMap.get("beforeMarshalling").toString());
						tempList.add(targetMap.get("marshalling").toString());
						tempList.add(targetMap.get("invokingGalileo").toString());
						tempList.add(targetMap.get("unmarshallingAndSendToCmmmodServer").toString());
						
						outputList.add(String.join(",", tempList));
						
					}
					tempMap.remove(threadId);
				}
				continue;
			}
			
			matcher = logTranIdPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(1);
				String esbTranId = matcher.group(3);
				if(tempMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)tempMap.get(threadId)).put("esbTranId", esbTranId);
//					System.out.println("start 두번"+tempMap.get(threadId));
				}
				continue;
			}
			
			matcher = logCalltimePT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(1);
				String callTime = matcher.group(3);
				if(tempMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)tempMap.get(threadId)).put("callTime", callTime);
//					System.out.println("start 두번"+tempMap.get(threadId));
				}
				continue;
			}
			
			matcher = logLengthPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(1);
				String contentLength = matcher.group(3);
				if(tempMap.containsKey(threadId)) {//threadID가 맵에 존재하면 
					((HashMap)tempMap.get(threadId)).put("contentLength", contentLength);
//					System.out.println("start 두번"+tempMap.get(threadId));
				}
				continue;
			}
			
			matcher = logStopWatchPT.matcher(logLine);
			if(matcher.find()) {
				String threadId = matcher.group(1);
				if(tempMap.containsKey(threadId)) {
					int nextIdx = itList.nextIndex();
//					System.out.println(nextIdx);
//					System.out.println((String)(logList.get(nextIdx+3)));
					matcher = logRunTimePT.matcher((String)(logList.get(nextIdx+3)));
					if(matcher.find()) {
						((HashMap)tempMap.get(threadId)).put("beforeMarshalling", matcher.group(2));
					}
					matcher = logRunTimePT.matcher((String)(logList.get(nextIdx+4)));
					if(matcher.find()) {
						((HashMap)tempMap.get(threadId)).put("marshalling", matcher.group(2));
					}
					matcher = logRunTimePT.matcher((String)(logList.get(nextIdx+5)));
					if(matcher.find()) {
						((HashMap)tempMap.get(threadId)).put("invokingGalileo", matcher.group(2));
					}
					matcher = logRunTimePT.matcher((String)(logList.get(nextIdx+6)));
					if(matcher.find()) {
						((HashMap)tempMap.get(threadId)).put("unmarshallingAndSendToCmmmodServer", matcher.group(2));
					}
					continue;
				}
				continue;
			}
			
		}
		
		
		System.gc();
		long aftUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long useMemory =  (preUseMemory - aftUseMemory) / 1000;
		System.out.println("pre"+preUseMemory);
		System.out.println("af"+preUseMemory);
		System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
		System.out.println(useMemory);
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0);
		return threadMap;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		
	}

}

