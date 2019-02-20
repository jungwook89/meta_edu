package logFileAnalysis;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
public class LogFileReadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long start = System.currentTimeMillis();
		Path pa = FileSystems.getDefault().getPath("C:\\galileo.log");
		try {
		Iterable<String> logList =Files.readAllLines(pa);
		long start = System.currentTimeMillis();
		for (String logLine:logList) {
			if(logLine.contains("eclipse.galileo-bean-thread")) {
//				System.out.println(logLine);
			}
		}
		double one = (System.currentTimeMillis()-start)/1000.0;
		System.out.println("컨테인"+one);
		for (String logLine:logList) {
			if(logLine.indexOf("eclipse.galileo-bean-thread")>-1) {
//				System.out.println(logLine);
			}
		}
		double two = (System.currentTimeMillis()-start)/1000.0;
		System.out.println("인덱스"+(two-one));
		for (String logLine:logList) {
			if(logLine.matches(".*(eclipse.galileo-bean-thread)+.*")) {
//				System.out.println(logLine);
			}
		}
		double three = (System.currentTimeMillis()-start)/1000.0;
		System.out.println("매치"+(three-(one+two)));
		}catch(Exception e) {
			e.printStackTrace();
		}
//		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0);
		
		
		Map<String, Object> findMap = new HashMap<String,Object>();
		
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
