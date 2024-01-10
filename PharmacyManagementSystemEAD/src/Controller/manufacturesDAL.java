/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.manufacturesBLL;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
/**
 *
 * @author Pasith Senevirathna
 */
public class manufacturesDAL {
        // <editor-fold defaultstate="collapsed" desc="Connection String">
    Connection con = connectionDAL.mycon();
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Insert Data From Database">
    public boolean Insert(manufacturesBLL m) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into tbl_manufactures (name,address,email,mobile,added_date,added_by,updated_date,updated_by,status) Values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, m.getManufacturerName());
            ps.setString(2, m.getManufacturerAddress());
            ps.setString(3, m.getManufacturerEmail());
            ps.setString(4, m.getManufacturerMobile());
            ps.setDate(5, (Date) m.getAdded_date());
            ps.setInt(6, 1);
            ps.setDate(7, (Date) m.getAdded_date());
            ps.setInt(8, 1);
            ps.setInt(9, 1);

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
    
     // <editor-fold defaultstate="collapsed" desc="Update Data From Databse">
    
    public boolean Update(manufacturesBLL m) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("Update tbl_manufactures Set name=?,address=?,email=?,mobile=?,updated_date=?,updated_by=? Where id=?");
            ps.setString(1, m.getManufacturerName());
            ps.setString(2, m.getManufacturerAddress());
            ps.setString(3, m.getManufacturerEmail());
            ps.setString(4, m.getManufacturerMobile());
            ps.setDate(5, (Date) m.getUpdated_date());
            ps.setInt(6, 1);
            ps.setInt(7, m.getManufacturerID());

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
    
     // <editor-fold defaultstate="collapsed" desc="Delete Data From Databse">
    
    public boolean Delete(manufacturesBLL m) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("Update tbl_manufactures Set status=0 Where id=?");
            
            ps.setInt(1, m.getManufacturerID());

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
