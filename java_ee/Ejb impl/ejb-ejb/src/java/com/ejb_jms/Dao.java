/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb_jms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duncan
 */
public class Dao {

    private static Connection getConnection() throws SQLException {
        String connectionURL = "jdbc:mysql://localhost/test?user=root&password=''";
        Connection conn = DriverManager.getConnection(connectionURL);
        return conn;
    }

    public String getUserName(int id) {
        String usrName ="";
        try {
            Connection conn = getConnection();
            String userName = "{ call getUserName(?) }";
            CallableStatement cs = conn.prepareCall(userName);
            cs.setInt(1, id);
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.execute();
            usrName = cs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usrName;
    }

}
