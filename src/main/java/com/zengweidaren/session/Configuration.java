package com.zengweidaren.session;

import com.zengweidaren.binding.MapperMethod;
import com.zengweidaren.binding.MapperRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取xml文件加载到内存中
 */
public class Configuration {
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    //1、domgj 去解析mybaits-config.xml
    MapperRegistry mapperRegistry =new MapperRegistry();

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }

    public void setMapperRegistry(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    public void loadConfigurations ()throws  Exception{
        try {
            Document document = new SAXReader().read(inputStream);
            Element root = document.getRootElement();
            List<Element> mappers = root.element("mappers").elements("mapper");
            for(Element element:mappers){
                if(element.attribute("resource")!=null){
                    try {
                        mapperRegistry.setKnownMappers(loadXMLconfiguration(element.attribute("resource").getText()));
                    } catch (Exception e) {
                        System.out.println("配置文件配置错了，-------------小子！");
                    }
                }
                if(element.attribute("class")!=null){

                }
            }
        }catch (Exception e){
            System.out.println("配置文件配置错了，小子！");
        }finally {
            inputStream.close();
        }
    }

    /**
     * dom4j 解析 TestDaoMapper.xml
     * @param resource
     * @return
     * @throws Exception
     */
    private Map<String,MapperMethod> loadXMLconfiguration(String resource)throws Exception{
        Map<String,MapperMethod> map =new HashMap<String,MapperMethod>();
        InputStream is=null;
        try {
            is=this.getClass().getClassLoader().getResourceAsStream(resource);
            Document document = new SAXReader().read(is);
            Element root = document.getRootElement();
            if(root.getName().equalsIgnoreCase("mapper")){
                String namespace = root.attribute("namespace").getText();
                System.out.println(namespace);
                for(Element select: (List<Element>) root.elements("select")){
                    MapperMethod mapperMethod =new MapperMethod();
                    mapperMethod.setSql(select.getText().trim());
                    System.out.println("select="+select.getText().trim());
                    mapperMethod.setType(Class.forName(select.attribute("resultType").getText()));
                    System.out.println("result="+Class.forName(select.attribute("resultType").getText()));
                    map.put(namespace+"."+select.attribute("id").getText(),mapperMethod);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            is.close();
        }
        return map;
    }
}
