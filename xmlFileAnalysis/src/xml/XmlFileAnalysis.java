package xml;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlFileAnalysis {
	private File rootFile;//package 위치
	private File rootFilePath;
	private String rootPath;
	private ArrayList<File> rootList;
	public XmlFileAnalysis(String rootFilePath){
		this.rootFile = new File(rootFilePath);
	}
	public Document xmlFileReader(String path) throws ParserConfigurationException, SAXException,IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(path);
		return document;
	}
	
	public Map<String, Object> fileFinder(String file_id) {
//		Map findList= new ArrayList<File>();
		Map<String, Object> findMap = new HashMap<String,Object>();
		ArrayList<File> rootList= new ArrayList<File>(Arrays.asList(rootFile.listFiles()));
		String curName;
		for(File file:rootList) {
//			System.out.println(one.getName());
			curName = file.getName();
			String reg1 = "(^[FP]_"+file_id+"_TB.xml$)";
			Pattern p = Pattern.compile(reg1);
			Matcher m = p.matcher(curName);
			if(m.find()) {
//				System.out.println(curName);
//				System.out.println((file.getParentFile().toString())+File.separator+curName);
				if((file.getName()).charAt(0)=='F')
					findMap.put("F", new File((file.getParentFile().toString())+File.separator+curName));
				else
					findMap.put("P", new File((file.getParentFile().toString())+File.separator+curName));
//				findList.add(new File((file.getParentFile().toString())+File.separator+curName));
			}
		}
		return findMap;
	}
	
	public ArrayList<File> fileFinder(String path,String file_id) {
		File customFile = new File(path);
		ArrayList<File> customList= new ArrayList<File>(Arrays.asList(customFile.listFiles()));
		return customList;
	}
	

	public static void main(String[] args) {
		XmlFileAnalysis xml = new XmlFileAnalysis("C:\\dev\\github\\metabuild\\xmlFileAnalysis\\src\\xml\\xmlFiles");
		try {
		Document dm = xml.xmlFileReader("C:\\dev\\github\\metabuild\\xmlFileAnalysis\\src\\xml\\xmlFiles\\T_BASEFILE_TB.xml");
		XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        XPathExpression expr = xpath.compile("//FILE_ID");
        NodeList nodeList = (NodeList) expr.evaluate(dm, XPathConstants.NODESET);
        for(int i = 0; i < nodeList.getLength(); i++){
        	String curNodeId=nodeList.item(i).getTextContent();
        	Map<String, Object> findMap = xml.fileFinder(curNodeId);
        	File fFile = (File)findMap.get("F");
        	File pFile = (File)findMap.get("P");
        	String fFilePath = fFile.getPath();
        	String pFilePath = pFile.getPath();
    		Document dmF = xml.xmlFileReader(fFilePath);
    		
    		Document dmP = xml.xmlFileReader(pFilePath);
    		XPathExpression fExpr = xpath.compile("//ROW[SIMILAR_RATE div 100 > 15]");
    		NodeList fNodeList = (NodeList) fExpr.evaluate(dmF, XPathConstants.NODESET);
    		for(int j = 0; j < fNodeList.getLength(); j++){
    			Element fElement = (Element)fNodeList.item(j).getChildNodes();
    			String pId = fElement.getElementsByTagName("P_ID").item(0).getTextContent();
    			if(pId == "") {
    				continue;
    			}
    			
    			
    			String strExp = "//ROW[P_ID=295271]/LICENSE_ID";
    			System.out.println(strExp);
    			XPathExpression pExpr = xpath.compile(strExp);
    			
    			NodeList pNodeList = (NodeList)pExpr.evaluate(dmP, XPathConstants.NODESET);
    			System.out.println(pNodeList.getLength());
//    			if(pNode.getNodeValue()!=null) {
//    				System.out.println(pNode.getNodeValue());
//    			}
    			if(pNodeList.getLength()!=0) {
    			System.out.println("하하"+pNodeList.item(0).getNodeValue());
    			}
    			
//    			if(pNodeList.item(0).getNodeValue()!=null){
//    				System.out.println("라이센스"+pNodeList.item(0).getNodeValue());
//    			}
//    			System.out.println(pId);
//    			System.out.println(fElement.getTextContent());
    		}
        	
        	
        }
//        System.out.println(nodeList.getLength());
//        NodeList childList = nodeList.item(0).getChildNodes();
//        System.out.println(nodeList.item(0).getNodeName());
//        System.out.println("시작");
//		System.out.println(childList.item(0).getNodeName());
		}catch(NullPointerException ne) {
			ne.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
