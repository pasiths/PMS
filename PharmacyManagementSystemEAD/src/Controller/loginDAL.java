/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.loginBLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pasith Senevirathna
 */
public class loginDAL {
    // <editor-fold defaultstate="collapsed" desc="Connection String">

    Connection con = connectionDAL.mycon();

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="check">
    public boolean loginCheck(loginBLL l) {
        boolean isSuccess = false;
        try {
            //Query to get the number of rows in a table
            String query = "SELECT COUNT(status) FROM tbl_users WHERE status=1";
            PreparedStatement ps = con.prepareStatement(query);
            //Executing the query
            ResultSet rs = ps.executeQuery();
            //Retrieving the result
            rs.next();
            int count = rs.getInt(1);
            if (count == 0) {
                if (l.getUsername().equals("admin") && l.getPassword().equals("admin")) {
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }
            } else {
                try {
                    PreparedStatement st = con.prepareStatement("Select name, password from tbl_users where name=? and password=? AND status=1");

                    st.setString(1, l.getUsername());
                    st.setString(2, l.getPassword());
                    ResultSet rss = st.executeQuery();
                    if (rss.next()) {
                        isSuccess=true;
                    } else {
                        isSuccess=false;
                    }
                } catch (Exception ex) {
                    System.err.println("ERROR: " + ex.getMessage());
                }
            }

        } catch (Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            connectionDAL.myconClose();
        }
        return isSuccess;
    }
    // </editor-fold>

}
