/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.userBLL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Pasith Senevirathna
 */
public class userDAL {
        // <editor-fold defaultstate="collapsed" desc="Connection String">
    Connection con = connectionDAL.mycon();
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Insert Data From Database">
    public boolean Insert(userBLL u) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into tbl_users (name,dob,email,username,password,gender,mobile,user_type,address,added_date,added_by,updated_date,updated_by,status) Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getsDOB());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getUsername());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getGender());
            ps.setString(7, u.getMobile());
            ps.setString(8, u.getUser_type());
            ps.setString(9, u.getAddress());
            ps.setDate(10, (Date) u.getAdded_date());
            ps.setInt(11, 1);
            ps.setDate(12, (Date) u.getAdded_date());
            ps.setInt(13, 1);
            ps.setInt(14, 1);

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
    
    public boolean Update(userBLL u) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("Update tbl_users Set name=?,dob=?,email=?,username=?,password=?,gender=?,mobile=?,user_type=?,address=?,updated_date=?,updated_by=? Where id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getsDOB());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getUsername());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getGender());
            ps.setString(7, u.getMobile());
            ps.setString(8, u.getUser_type());
            ps.setString(9, u.getAddress());
            ps.setDate(10, (Date) u.getUpdated_date());
            ps.setInt(11, 1);
            ps.setInt(12, u.getId());

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
    
    public boolean Delete(userBLL u) {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = con.prepareStatement("Update tbl_users Set status=0 Where id=?");
            
            ps.setInt(1, u.getId());

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
