/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.manufacturesBLL;
import Model.transctionsBLL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pasith Senevirathna
 */
public class transactionDAL {
    // <editor-fold defaultstate="collapsed" desc="Connection String">

    Connection con = connectionDAL.mycon();

    // </editor-fold>
    public int CID() {
        int cusId = 1;
        try {
            String query = "SELECT COUNT(id) FROM tbl_transaction";
            PreparedStatement ps = con.prepareStatement(query);
            //Executing the query
            ResultSet rs = ps.executeQuery();
            //Retrieving the result
            rs.next();
            int count = rs.getInt(1);
            if (count == 0) {
                cusId = 1;
                System.err.println(cusId);
            } else {
                try {
                    query = "select id from tbl_transaction ORDER BY id DESC LIMIT 1";
                    PreparedStatement pss = con.prepareStatement(query);
                    ResultSet rss = pss.executeQuery();
                    rss.next();
                    cusId = rss.getInt(1) + 1;
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            connectionDAL.myconClose();
        }
        return cusId;
    }

    // <editor-fold defaultstate="collapsed" desc="Insert Data From Database">
    public boolean Insert(transctionsBLL tb) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into tbl_transaction (id,c_name,total,cash,balance,added_date,added_by) Values (?,?,?,?,?,?,?)");
            ps.setInt(1, tb.getCid());
            ps.setString(2, tb.getName());
            ps.setDouble(3, tb.getTotal());
            ps.setDouble(4, tb.getCash());
            ps.setDouble(5, tb.getBalance());
            ps.setDate(6, (Date) tb.getAdded_date());
            ps.setInt(7, 1);

            int status = ps.executeUpdate();
            if (status == 1) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }

        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            connectionDAL.myconClose();
        }
        return isSuccess;
    }
// </editor-fold> 
}
