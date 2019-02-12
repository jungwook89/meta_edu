package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlFileAnalysis {
	private File rootFile;
	private File path;
	private ArrayList<File> rootList;
	public XmlFileAnalysis(String root){
		this.rootFile = new File(root);
		ArrayList<File> rootList= new ArrayList<File>(Arrays.asList(path.listFiles()));
	}
	
	
	public ArrayList<File> fileFinder(String file_id) {
		
		return false;
	}
	
	public boolean checkRate(File check_file) {
		String reg1 = "(^[FP]_"+file_id+"_TB.xml$)";
		System.out.println(reg1);
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File path = new File("C:\\dev\\github\\metabuild\\xmlFileAnalysis\\src\\xml\\xmlFiles");
		ArrayList<File> list= new ArrayList<File>(Arrays.asList(path.listFiles()));
		
		XmlFileAnalysis xml = new XmlFileAnalysis("C:\\dev\\github\\metabuild\\xmlFileAnalysis\\src\\xml\\xmlFiles");
		String curName;
		for(File one:list) {
//			System.out.println(one.getName());
			curName = one.getName();
			String reg1 = "(^[FP]_"+"0"+"_TB.xml$)";
			Pattern p = Pattern.compile(reg1);
			Matcher m = p.matcher(curName);
			if(m.find()) {
				System.out.println(curName);
				System.out.println((one.getParentFile().toString())+File.separator+curName);
			}
			
		}
		xml.fileFinder("0");
	}

}
