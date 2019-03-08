/*

 * 작성일 : 2019. 3. 8.

 * 작성자 : meta

 *

 * 설명

 */




package logFileAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LogFileExport {

	private String outputPath = null;
	private List<String> targetList = null;
	public LogFileExport(String outputPath) {
		this.outputPath = outputPath;
	}
	protected boolean outputFile(Object targetData) {
		if (targetData instanceof HashMap) {
//		    targetList = Arrays.asList(targetData);
		} else if (targetData instanceof List) {
			targetList = (List<String>)(targetData);
		}else {
			return false;
		}
		BufferedWriter fw =null;
		List<String> allLineList = new ArrayList<String>();
		try {
			File targetFile = new File(outputPath);
			if(!targetFile.exists()) {
				targetFile.createNewFile();
			}
			
			fw = new BufferedWriter(new FileWriter(targetFile, false));
//			for(String oneLine: targetList) {
//				fw.write(oneLine);
//			}
			fw.write(String.join("\n", targetList));
			fw.flush();
			fw.close();
			return true;
				
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


