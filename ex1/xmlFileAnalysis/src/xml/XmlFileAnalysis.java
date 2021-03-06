package xml;

import java.io.File;
import java.io.FileOutputStream;
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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
		Map<String, Object> tempMap = new HashMap<String,Object>();
		Map<String, Object> findMap = new HashMap<String,Object>();
		ArrayList<File> rootList= new ArrayList<File>(Arrays.asList(rootFile.listFiles()));
		String curName;
		for(File file:rootList) {
			curName = file.getName();
			String reg1 = "(^[FP]_"+file_id+"_TB.xml$)";
			Pattern p = Pattern.compile(reg1);
			Matcher m = p.matcher(curName);
			if(m.find()) {
				if((file.getName()).charAt(0)=='F')
					tempMap.put("F", new File(file.getPath()));
				else
					tempMap.put("P", new File(file.getPath()));
			}
			tempMap.put(curName, tempMap);
		}
		return tempMap;
	}
	public ArrayList<File> fileFinder(String path,String file_id) {
		File customFile = new File(path);
		ArrayList<File> customList= new ArrayList<File>(Arrays.asList(customFile.listFiles()));
		return customList;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		XmlFileAnalysis xml = new XmlFileAnalysis("C:\\dev\\github\\metabuild\\xmlFileAnalysis\\src\\xml\\xmlFiles");
		try {
			Document dm = xml.xmlFileReader("C:\\dev\\github\\metabuild\\xmlFileAnalysis\\src\\xml\\xmlFiles\\T_BASEFILE_TB.xml");
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//FILE_ID");
			NodeList nodeList = (NodeList) expr.evaluate(dm, XPathConstants.NODESET);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
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
					if(pId == "") { continue; }
					XPathExpression pExpr = xpath.compile("//ROW[P_ID="+pId+"]/LICENSE_ID");
					NodeList pNodeList = (NodeList)pExpr.evaluate(dmP, XPathConstants.NODESET);
					if(pNodeList.getLength()!=0 && pNodeList.item(0).getTextContent()!="") {
						String comment = pNodeList.item(0).getTextContent();
						fElement.getElementsByTagName("COMMENT").item(0).setTextContent(comment);
						//결과가 0이아니고 ""이 아니면 코멘트에 값 세팅
					}
				}
				DOMSource source = new DOMSource(dmF);
				StreamResult result = new StreamResult(new FileOutputStream(
						new File("C:\\dev\\github\\metabuild\\xmlFileAnalysis\\src\\xml\\xmlFiles\\t_"+curNodeId+"_TB.xml")));
				transformer.transform(source, result);
				//파일을 만들어서 세팅한 값 저장
			}
		}catch(NullPointerException ne) {
			ne.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000);
	}

}
