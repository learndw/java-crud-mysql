/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sistemagestionfinal;

import com.mycompany.sistemagestionfinal.forms.Formulario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Usuariosc
 */
public class SistemagestionFinal {

    public static void main(String[] args) {
        Formulario ventana=new Formulario();
        ventana.show();
    }
    
//    public static void main(String[] args) throws IOException {
//
//        System.out.println("Ingresar un valor:");
//        Integer valor = cargarNumero();
//        Boolean esPar = valor % 2 == 0;
//        if (esPar) {
//            System.out.println("Es par el numero: " + valor);
//        } else {
//            System.out.println("No es par el numero: " + valor);
//        }
//
//    }
//
//    public static Integer cargarNumero() throws IOException {
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(inputStreamReader);
//        String strNumero = reader.readLine();
//        Integer numero = Integer.parseInt(strNumero);
//
//        return numero;
//    }
}
