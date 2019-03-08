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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

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
	private String filePath = null; //파일 경로
	private List<String> allLineList = new ArrayList<String>();
	public LogFileReader(String filePath) {
		this.filePath = filePath;
	}
	protected List<String> readFile(){
		BufferedReader br = null;
		
		try {
			File targetFile = new File(filePath);
			if(targetFile.exists()) {
				FileInputStream fstream = new FileInputStream(targetFile);
				br = new BufferedReader(new InputStreamReader(fstream));
		
				String strLine;
		
				//한줄 읽기
				while ((strLine = br.readLine()) != null){
				  // 테스트 출력
					allLineList.add(strLine);
//				  System.out.println (strLine);
				}
				br.close();
				return allLineList;
				
			}else {
				System.out.println("파일이 존재하지 않습니다.");
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		//닫기
		
		return null;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LogFileReader lfr = new LogFileReader("C:\\galileo.log");
		List<String> testList = lfr.readFile();
		for(String one : testList) {
			System.out.println(one);
		}
		
//		
	}

}

