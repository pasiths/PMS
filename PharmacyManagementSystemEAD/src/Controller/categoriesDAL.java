/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.categoriesBLL;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
//import java.util.Date;

/**
 *
 * @author Pasith Senevirathna
 */
public class categoriesDAL {

    // <editor-fold defaultstate="collapsed" desc="Connection String">
    Connection con = connectionDAL.mycon();
    // </editor-fold> 

    //categoriesBLL c = new categoriesBLL();
    // <editor-fold defaultstate="collapsed" desc="Select Data From Databse">
//    public DataTable Select(){
//    }
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Insert Data From Database">
    public boolean Insert(categoriesBLL c) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into tbl_categories (title,description,added_date,added_by,updated_date,updated_by,status) Values (?,?,?,?,?,?,?)");
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getDescription());
            ps.setDate(3, (Date) c.getAdded_date());
            ps.setInt(4, 1);
            ps.setDate(5, (Date) c.getAdded_date());
            ps.setInt(6, 1);
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
    
     // <editor-fold defaultstate="collapsed" desc="Update Data From Databse">
    
    public boolean Update(categoriesBLL c) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("Update tbl_categories Set title=?,description=?,updated_date=?,updated_by=? Where id=?");
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getDescription());
            ps.setDate(3, (Date) c.getUpdated_date());
            ps.setInt(4, 1);
            ps.setInt(5, c.getId());

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
    
    public boolean Delete(categoriesBLL c) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("Update tbl_categories Set status=0 Where id=?");
            
            ps.setInt(1, c.getId());

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
