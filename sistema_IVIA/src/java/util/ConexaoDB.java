/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valdir.silva
 */
public class ConexaoDB {

    private static Connection conexao;
    private static final String URL = "jdbc:mysql://localhost/sistema_ivia";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
