package a.b.c.test.xml;

// 여기서 이 2개는 자바꺼다.
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

// 나머지 4개는 자바 개발자가 만든 것
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class ReadXMLClass {
	
	public static final String XML_FILE_PATH = "C:\\00.KOSMO108\\30.Web\\eclipse_web_work_psh\\kosmoMember\\WebContent\\kos_xml";
	
	public static void main(String argv[]) {
	
		String testClass = "";
		
		try {
			
			// Tomcat 서버에서 웹 서버(코요테)위치에 있는 fileClass.xml 파일을 
			// Tomcat 서버가 설치된 로컬 경로에 있는 물리적 파일 위치를 찾아서 
			// (- 그 물리적인 파일 위치는 C:\\00.KOSMO108\\30.Web\\eclipse_web_work_psh\\kosmoMember\\WebContent\\kos_xml 요거다._
			// java.io.File 객체로 읽오는 것이다. 
			// java.io.File 객체를 물리적 경로를 읽는 객체이다. 
			String xmlFilePath = ReadXMLClass.XML_FILE_PATH;
			File fXmlFile = new File( xmlFilePath + "/fileClass.xml");
			
			// 팩토리 디자인 패턴 : 형식 : xml 파일을 읽어서 파싱 (파싱은 번역가라고 생각하면 된다.)
			// 물리적인 xml 파일을 xml 객체로 변환하기 위해서 팩토리 디자인 패턴을 이용한다. 	
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			// parse() 함수가 물리적인 xml 파일을 파싱해서 메모리에 xml 객체로 변환 시킨다.
			Document doc = dBuilder.parse(fXmlFile);
			
			// xml 문서를 깨끗하게 만드세요 
			doc.getDocumentElement().normalize();
			
			System.out.println("	Root element : " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("testclass");
			System.out.println("	------------------------------------");
			
			// 신기한게 여기는 렝스로 받는다.
			for ( int temp = 0; temp < nList.getLength(); temp++ ) {
				
				// 노드는 간단하게 생각하면 HTML의 모든 요소라고 생각하면 편하다.
				Node nNode = nList.item(temp);
				
				if ( nNode.getNodeType() == Node.ELEMENT_NODE ) {
					
					Element eElement = (Element) nNode;
					
					testClass = getTagValue("test",eElement);
					System.out.println("	test 는 ?	>>> : " + testClass);
				}
				
			}
			
			try {
				
				Class cla_1 = Class.forName(testClass);
				TestClass classAction = (TestClass)cla_1.newInstance();
				System.out.println("	classAction 은 ?	>>> : " + classAction);
				classAction.test();
				
			}catch (Exception e) {
				
//				catch (ClassNotFoundException e){}
//				catch (InstantiationException i){}
//				catch (IllegalAccessException il){}
				
			}
				
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
	}
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}









