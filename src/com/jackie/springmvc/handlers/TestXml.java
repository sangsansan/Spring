package com.jackie.springmvc.handlers;



import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TestXml {

	public static void main(String[] args) {
		Nation nation = new Nation();
		Province province = new Province();
		List<Nation> nationlist = new ArrayList<Nation>();
		List<Province> provincelist = new ArrayList<Province>();
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse("WebContent/1.xml");
			Element element = document.getDocumentElement();

			NodeList nations = element.getElementsByTagName("Nation");
			for (int i=0; i<nations.getLength(); i++) {
				nation = new Nation();
				Element nationNode = (Element) nations.item(i);

				String country = nationNode.getElementsByTagName("Country").item(0).getTextContent();
				System.out.println(country);
				nation.setCountry(country);
 
				String city = nationNode.getElementsByTagName("City").item(0).getTextContent();
				System.out.println(city);
				nation.setCity(city);

				NodeList provinceNodes = nationNode.getElementsByTagName("Province");
				provincelist = new ArrayList<Province>();
				for (int j=0; j<provinceNodes.getLength(); j++) {
					
					province = new Province();
					Element provinceNode = (Element) provinceNodes.item(j);

					String provinceName = provinceNode.getElementsByTagName("ProvinceName").item(0).getTextContent();
					System.out.println(provinceName);
					province.setProvinceName(provinceName);

					String population = provinceNode.getElementsByTagName("Population").item(0).getTextContent();
					System.out.println(population);
					province.setPopulation(population);
					provincelist.add(province);
					
				}
				nation.setPrvince(provincelist);
				nationlist.add(nation);
			}
			//for (int i = 0;i<nationlist.size();i++) {
			    System.out.println("========="+nationlist.size());
			    System.out.println("========="+nationlist.get(0).getPrvince().size());
			    System.out.println("========="+nationlist.get(1).getPrvince().size());
				System.out.println("======"+nationlist.get(0).getCountry());
				System.out.println("======"+nationlist.get(0).getPrvince().get(0).getProvinceName());
				System.out.println("======"+nationlist.get(0).getPrvince().get(1).getProvinceName());
				System.out.println("======"+nationlist.get(1).getCountry());
				System.out.println("======"+nationlist.get(1).getPrvince().get(0).getProvinceName());
				//System.out.println("======"+nationlist.get(1).getPrvince().get(1).getProvinceName());
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}



//		Element element = null;
//		File f = new File("Webcontent/1.xml");
//		DocumentBuilder db = null; // documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
//		DocumentBuilderFactory dbf = null;
//		List<Nation> list = new ArrayList<Nation>();
//		List<Province> list1 = new ArrayList<Province>();
//		Nation nation = new Nation();
//		Province province = new Province();
//		try {
//			dbf = DocumentBuilderFactory.newInstance(); // 返回documentBuilderFactory对象
//			db = dbf.newDocumentBuilder();// 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
//			Document dt = db.parse(f); // 得到一个DOM并返回给document对象
//			element = dt.getDocumentElement();// 得到一个elment根元素
//			System.out.println("根元素：" + element.getNodeName()); // 获得根节点
//			NodeList childNodes = element.getElementsByTagName("Nation"); // 获得根元素下的子节点
//
//			System.out.println(childNodes.getLength());

//			for (int i = 0; i < childNodes.getLength(); i++) // 遍历这些子节点
//			{
//				Node node1 = childNodes.item(i); // childNodes.item(i);
//				// 获得每个对应位置i的结点
//
//				NodeList nodeDetail = node1.getChildNodes(); // 获得<Accounts>下的节点
//				nation = new Nation();
//				for (int j = 0; j < nodeDetail.getLength(); j++) { // 遍历<Accounts>下的节点
//
//					// System.out.println("1111"+nodeDetail.getLength());
//					Node detail = nodeDetail.item(j); // 获得<Accounts>元素每一个节点
//					if (!(detail instanceof Element))
//						continue;
//					if ("Country".equals(detail.getNodeName())) {
//						// // 如果节点的名称为"Account"，则输出Account元素属性type
//						String country = detail.getTextContent();
//						// System.out.println("country"+
//						// detail.getTextContent());
//
//						nation.setCountry(country);
//						// System.out.println(nation.getCountry());
//
//					}
//					if ("Province".equals(detail.getNodeName())) {
//						province = new Province();
//						System.out.println("=======here");
//						NodeList nodeprovince = detail.getChildNodes();
//						for (int k = 0; k < nodeprovince.getLength(); k++) {
//							// System.out.println("2222"+nodeprovince.getLength());
//
//							Node nodeprodetail = nodeprovince.item(k);
//							if (!(nodeprodetail instanceof Element))
//								continue;
//							if ("ProvinceName".equals(nodeprodetail.getNodeName())) {
//								String provinceName = nodeprodetail.getTextContent();
//								System.out.println("provinceName" + provinceName);
//								province.setProvinceName(provinceName);
//
//								System.out.println("list1.size" + list1.size());
//								// System.out.println("1111"+list1.size());
//							}
//
//						}
//
//						list1.add(province);
//					}
//
//				}
//				nation.setPrvince(list1);
//				list.add(nation);
//
//			}
//			System.out.println(list1.size());
//			// System.out.println(list1.get(0).getProvinceName());
//			System.out.println(list.size());
//			for (int i = 0; i < list1.size(); i++) {
//
//				System.out.println("1111111" + list1.get(i).getProvinceName());
//			}
//			for (int i = 0; i < list.size(); i++) {
//
//				System.out.println("222222" + list.get(i).getCountry());
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
	}

}
