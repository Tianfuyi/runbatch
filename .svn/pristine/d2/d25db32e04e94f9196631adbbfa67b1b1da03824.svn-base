package com.cmi.tools;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataParse {

    /**
     * @param name 取值名称
     * @return
     * @throws IOException
     */
    public static String GetProperties(String name) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/framework.properties");

        try {
            properties.load(inputStream);
            return properties.getProperty(name);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    /**
     * @param filename  配置文件名称
     * @param name 取值名称
     * @return
     * @throws IOException
     */
    public static String GetProperties(String filename,String name) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/"+filename);

        try {
            properties.load(inputStream);
            return properties.getProperty(name);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println(DataParse.GetProperties("framework.properties","USER"));
        System.out.println(DataParse.GetProperties("USER"));
    }
}

