/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pasith Senevirathna
 */
public class connectionDAL {

    private static Connection c = null;

    public static Connection mycon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pharmacy", "root", "@Pasith#2002");

        } catch (Exception ex) {
            System.err.println(ex);
        }
        return c;
    }

    public static void myconClose() {
        try {
            if (c != null) {
                c.close(); // Close the connection
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
