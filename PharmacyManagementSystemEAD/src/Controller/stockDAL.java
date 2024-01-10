/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.stockBLL;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;

/**
 *
 * @author Pasith Senevirathna
 */
public class stockDAL {
    Connection con = connectionDAL.mycon();
    public boolean Insert(stockBLL s){
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into tbl_stock (name,type,qty,price,man_id,added_date,added_by,updated_date,updated_by,status) Values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getType());
            ps.setInt(3, s.getQty());
            ps.setDouble(4, s.getPrice());
            ps.setInt(5, 1);
            ps.setDate(6, (Date) s.getAdded_date());
            ps.setInt(7, 1);
            ps.setDate(8, (Date) s.getAdded_date());
            ps.setInt(9, 1);
            ps.setInt(10, 1);
            
            int status = ps.executeUpdate();
            if (status == 1) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
            
        } catch (Exception e) {
             System.err.println(e);
        }finally {
            connectionDAL.myconClose();
        }
        
        return isSuccess;
    }

}
