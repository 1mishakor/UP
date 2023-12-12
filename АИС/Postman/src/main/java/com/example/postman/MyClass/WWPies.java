package com.example.postman.MyClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WWPies {
    private Properties properties = new Properties();
    public WWPies(String directory) {
        this.directory = directory;
    }

    public WWPies() {
    }

    String directory;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void writeProperty(String key, String meaning) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(directory);
            properties.load(in);
            in.close();
            properties.setProperty(key, meaning);
            FileOutputStream out = new FileOutputStream(directory);
            properties.store(out, null);
            out.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getElement(String elements) {
        String element = "nullElement";
        try {
            FileInputStream in = new FileInputStream(getDirectory());
            properties.load(in);
            element = properties.getProperty(elements);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return element;
    }
    public String getElement(String directory, String elements) {
        String element = "nullElement";
        try {
            FileInputStream in = new FileInputStream(directory);
            properties.load(in);
            element = properties.getProperty(elements);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return element;
    }
    public void clearProperties(){
        try {
            FileInputStream in = new FileInputStream(directory);
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(properties.size());
        for (int i = 0; i < properties.size(); i++) {
            properties.remove(String.valueOf(i));
        }

    }

}
