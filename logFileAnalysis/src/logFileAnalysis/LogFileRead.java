package logFileAnalysis;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
public class LogFileRead {

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
