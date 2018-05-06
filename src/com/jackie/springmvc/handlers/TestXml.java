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
//		DocumentBuilder db = null; // documentBuilderΪ������ֱ��ʵ����(��XML�ļ�ת��ΪDOM�ļ�)
//		DocumentBuilderFactory dbf = null;
//		List<Nation> list = new ArrayList<Nation>();
//		List<Province> list1 = new ArrayList<Province>();
//		Nation nation = new Nation();
//		Province province = new Province();
//		try {
//			dbf = DocumentBuilderFactory.newInstance(); // ����documentBuilderFactory����
//			db = dbf.newDocumentBuilder();// ����db������documentBuilderFatory�����÷���documentBuildr����
//			Document dt = db.parse(f); // �õ�һ��DOM�����ظ�document����
//			element = dt.getDocumentElement();// �õ�һ��elment��Ԫ��
//			System.out.println("��Ԫ�أ�" + element.getNodeName()); // ��ø��ڵ�
//			NodeList childNodes = element.getElementsByTagName("Nation"); // ��ø�Ԫ���µ��ӽڵ�
//
//			System.out.println(childNodes.getLength());

//			for (int i = 0; i < childNodes.getLength(); i++) // ������Щ�ӽڵ�
//			{
//				Node node1 = childNodes.item(i); // childNodes.item(i);
//				// ���ÿ����Ӧλ��i�Ľ��
//
//				NodeList nodeDetail = node1.getChildNodes(); // ���<Accounts>�µĽڵ�
//				nation = new Nation();
//				for (int j = 0; j < nodeDetail.getLength(); j++) { // ����<Accounts>�µĽڵ�
//
//					// System.out.println("1111"+nodeDetail.getLength());
//					Node detail = nodeDetail.item(j); // ���<Accounts>Ԫ��ÿһ���ڵ�
//					if (!(detail instanceof Element))
//						continue;
//					if ("Country".equals(detail.getNodeName())) {
//						// // ����ڵ������Ϊ"Account"�������AccountԪ������type
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
