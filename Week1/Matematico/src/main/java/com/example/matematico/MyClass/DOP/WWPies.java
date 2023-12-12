package com.example.matematico.MyClass.DOP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WWPies {
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
            Properties props = new Properties();
            props.load(in);
            in.close();
            props.setProperty(key, meaning);
            FileOutputStream out = new FileOutputStream(directory);
            props.store(out, null);
            out.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getElement(String elements) {
        String element = "nullElement";
        Properties properties = new Properties();
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
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(directory);
            properties.load(in);
            element = properties.getProperty(elements);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return element;
    }

}
