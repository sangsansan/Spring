package com.aaa;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

class Province {
    @XmlElement(name = "ProvinceName")
    String provinceName;

    @XmlElement(name = "Population")
    String population;
}

class Nation {
    @XmlElement(name = "Country")
    String country;

    @XmlElement(name = "City")
    String city;

    @XmlElement(name = "Province")
    List<Province> provinces;
}

@XmlRootElement(name = "TestA")
class TestA {
    @XmlElement(name = "Nation")
    List<Nation> nations;
}

public class MyTestXml {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TestA.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        TestA testA = (TestA) unmarshaller.unmarshal(new File("WebContent/11.xml"));

        for (Nation nation: testA.nations) {
            System.out.println(nation.country + " - " + nation.city);

            for (Province province: nation.provinces) {
                System.out.println("\t" + province.provinceName + " - " + province.population);
            }
        }
    }
}
