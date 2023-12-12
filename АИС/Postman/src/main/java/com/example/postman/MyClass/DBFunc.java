package com.example.postman.MyClass;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBFunc {
    public Connection connection_BD(String port, String database, String user_name, String password) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:" + port + "/" + database, user_name, password);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println("Error connection_BD: " + e);
        }
        return conn;
    }

    public void insertClient(Connection conn, String f, String n, String o, String l, String p) {
        Statement statement;
        String insert = String.format("insert into public.\"Clients\"(\"fam\", \"name\", \"otch\", \"login\", \"password\")\n" +
                "values ('%s', '%s', '%s', '%s', '%s');", f, n, o, l, p);
        try {
            statement = conn.createStatement();
            statement.executeUpdate(insert);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readLogins(Connection conn) {
        Statement statement;
        ResultSet rs = null;
        List<String> res = new ArrayList<>();
        try {
            String query = "select login from public.\"Clients\"";
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                res.add(rs.getString("login"));
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public String readPassword(Connection conn, String login) {
        Statement statement;
        ResultSet rs = null;
        String res = null;
        try {
            String query = String.format("select password from public.\"Clients\" where login = '%s'", login);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                res = rs.getString("password");
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public String readFio(Connection conn, String login) {
        Statement statement;
        ResultSet rs = null;
        String res = null;
        try {
            String query = String.format("select fam, name, otch from public.\"Clients\" where login = '%s'", login);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                res = rs.getString("fam") + " " + rs.getString("name") + " " + rs.getString("otch");
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public void insertMail(Connection conn, String topic, String sender, String recipient, String mail) {
        Statement statement;
        String insert = String.format("insert into public.\"Mail\" (\"topic\", \"sender\", \"recipient\", \"mail\")\n" +
                "values ('%s', '%s', '%s', '%s');", topic, sender, recipient, mail);
        try {
            statement = conn.createStatement();
            statement.executeUpdate(insert);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<String> readSend(Connection conn, String recipient) {
        Statement statement;
        ResultSet rs = null;
        WWPies wwPies1 = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\listIdMail.properties");
        //wwPies1.clearProperties();
        ObservableList<String> res = FXCollections.observableArrayList();
        try {
            String query = String.format("select topic, fam, name, otch, \"idMail\"\n" +
                    "from public.\"Mail\", public.\"Clients\"\n" +
                    "where login = sender and recipient = '%s'", recipient);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                wwPies1.writeProperty(String.valueOf(i),rs.getString("idMail"));
                i++;
                res.add("Тема: "+rs.getString("topic")+"\t от: "+rs.getString("fam")+" "+rs.getString("name")+" "+rs.getString("otch"));
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
    public ObservableList<String> readRecipient(Connection conn, String sender) {
        Statement statement;
        ResultSet rs = null;
        WWPies wwPies1 = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\listIdMail.properties");
        //wwPies1.clearProperties();
        ObservableList<String> res = FXCollections.observableArrayList();
        try {
            String query = String.format("select topic, fam, name, otch, \"idMail\"\n" +
                    "from public.\"Mail\", public.\"Clients\"\n" +
                    "where login = recipient and sender = '%s'", sender);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                wwPies1.writeProperty(String.valueOf(i),rs.getString("idMail"));
                i++;
                res.add("Тема: "+rs.getString("topic")+"\t Кому: "+rs.getString("fam")+" "+rs.getString("name")+" "+rs.getString("otch"));
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public String readMail(Connection conn, String id) {
        Statement statement;
        ResultSet rs = null;
        String res = null;
        try {
            String query = String.format("select mail\n" +
                    "from public.\"Mail\"\n" +
                    "where \"idMail\" = '%s'", id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                res=rs.getString("mail");
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }public String readTopic(Connection conn, String id) {
        Statement statement;
        ResultSet rs = null;
        String res = null;
        try {
            String query = String.format("select topic\n" +
                    "from public.\"Mail\"\n" +
                    "where \"idMail\" = '%s'", id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                res=rs.getString("topic");
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }public String readAfter(Connection conn, String id) {
        Statement statement;
        ResultSet rs = null;
        String res = null;
        try {
            String query = String.format("select fam, name, otch\n" +
                    "from public.\"Mail\", public.\"Clients\"\n" +
                    "where \"idMail\" = '%s' and login = sender", id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                res=rs.getString("fam")+" "+rs.getString("name")+" "+rs.getString("otch");
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }public String readAfterLogin(Connection conn, String id) {
        Statement statement;
        ResultSet rs = null;
        String res = null;
        try {
            String query = String.format("select login\n" +
                    "from public.\"Mail\", public.\"Clients\"\n" +
                    "where \"idMail\" = '%s' and login = sender", id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                res=rs.getString("login");
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
}
