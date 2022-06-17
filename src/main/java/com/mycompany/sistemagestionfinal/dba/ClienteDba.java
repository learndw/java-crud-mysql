/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionfinal.dba;

import com.mycompany.sistemagestionfinal.models.Cliente;
import com.mysql.jdbc.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuariosc
 */
public class ClienteDba {

    public Connection conectar() {
        String baseDeDatos = "gestion";
        String usuario = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";
        Connection conexion = null;
        try {
            //DriverManager.getConnection(conexionUrl,usuario, password);
            Class.forName(driver);
            conexion = DriverManager.getConnection(conexionUrl, usuario, password);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDba.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexion;
    }

    public void agregar(Cliente cliente) {
        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `telefono`, `email`) VALUES (NULL, '" + cliente.getNombre() + "', '" + cliente.getApellido() + "', '" + cliente.getTelefono() + "', '" + cliente.getEmail() + "')";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(Cliente cliente) {
        try {
            Connection conexion = conectar();
            String sql = "UPDATE `clientes` SET `nombre` = '"+cliente.getNombre()+"', `apellido` = '"+cliente.getApellido()+"', `telefono` = '"+cliente.getTelefono()+"', `email` = '"+cliente.getEmail()+"' WHERE `clientes`.`id` = '"+cliente.getId()+"'";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> listaClientes() {

        List<Cliente> listado = new ArrayList<>();
        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM `clientes`";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getString("id"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setEmail(resultado.getString("email"));
                listado.add(cliente);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDba.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listado;
    }

    public void eliminar(String id) {
        if(id!=null){
            try {
                Connection conexion = conectar();
                String sql = "DELETE FROM clientes WHERE `clientes`.`id` ='" + id + "'";
                Statement statement = conexion.createStatement();
                statement.execute(sql);
            } catch (Exception ex) {
                Logger.getLogger(ClienteDba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void guardar(Cliente cliente) {
       if(StringUtils.isEmptyOrWhitespaceOnly(cliente.getId())){
           agregar(cliente);
       }else{
           actualizar(cliente);
       }
    }
}
