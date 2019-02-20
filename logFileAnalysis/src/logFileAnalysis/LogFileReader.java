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

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long start = System.currentTimeMillis();
		Path pa = FileSystems.getDefault().getPath("C:\\galileo.log");
		try {
		Iterable<String> logList =Files.readAllLines(pa);
//		long start = System.currentTimeMillis();
		
		for (String logLine:logList) {
			
			if(logLine.indexOf("bean start.")>-1) {
				String threadStTime = logLine.substring(1,18);
				String threadNum=logLine.substring(58,66);
				String MapKey =threadStTime+threadNum;
				
				Map<String, Object> Map = new HashMap<String,Object>();
				System.out.println("st"+threadStTime+threadNum);

				
//				System.out.println(logLine);
			}
			if(logLine.indexOf("bean end.")>-1) {
				String threadEdTime = logLine.substring(1,18);
				String threadNum=logLine.substring(58,66);
				System.out.println("en"+threadEdTime+threadNum);
				String MapKey = threadEdTime+threadNum;
				
//				System.out.println(logLine);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
//		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0);
		
		
//		Map<String, Object> findMap = new HashMap<String,Object>();
		
//		long start = System.currentTimeMillis();
//		BufferedInputStream input = null;
//		try {
//		input = new BufferedInputStream(new FileInputStream("C:\\galileo.log"));
//        StringBuilder sb = new StringBuilder();
//        while (input.available() > 0) {
//            sb.append((char) input.read());
//        }
//        input.close();
////        System.out.println("read this :");
////        System.out.println(sb.toString());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0);
//		
	}

}

