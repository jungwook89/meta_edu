/*

 * 작성일 : 2019. 3. 7.

 * 작성자 : meta

 *

 * 설명

 */




package logFileAnalysis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LogFileAnalysisMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogFileReader lfr = new LogFileReader("C:\\galileo.log");
		List<String> testList = lfr.readFile();
//		for(String one : testList) {
//			System.out.println(one);
//		}
		LogAnalysis la = new LogAnalysis();
		la.logAnalysis(testList);
		List targetList = la.getBySortedList();
		
		LogFileExport lfe = new LogFileExport("C:\\galileo_analysis.log");
		System.out.println(lfe.outputFile(targetList));;
		
		
//		for(HashMap<String,Object> oneMap : Arrays.asList(testMap)) {
//			for(String key : oneMap.keySet()){
//				HashMap<String,Object> hoho = (HashMap<String, Object>) oneMap.get(key);
//				System.out.println(hoho.get("startTime"));
//			}
//			
//		}
	}

}


