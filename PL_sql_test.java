/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl_sql_test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author hp
 */
public class PL_sql_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3307/ass1_schema";
        String user = "root";
        String password = "1234512345";
        try {
            Connection conn = DriverManager.getConnection(dbURL, user, password);
            CallableStatement st;
            System.out.println("------------call update_salary ------stored procedure ------\n");
            st = conn.prepareCall("{call update_salary(?,?) }");
            st.setString(1, "Marketing Manager");
            st.setInt(2, 100);
            st.execute();

            System.out.println("------------call get_high_salary_job------function ------\n");
            st = conn.prepareCall("{?=call get_high_salary_job() }");
            st.registerOutParameter(1, Types.VARCHAR);
            st.execute();
            System.out.println("job_title for max salary : " + st.getString(1));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
 
    }

}
