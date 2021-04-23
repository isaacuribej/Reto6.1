/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto6;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Main {
    static Scanner linea= new Scanner(System.in);
    public static void main (String[] args) throws CustomException{
        Cajero usuario=new Cajero();
        HashMap<Object,Cajero> usuarios= new HashMap<>();
        
        String dato1 = null;
        while (!"Continuar".equals(dato1)){
            System.out.println("Desea 'Agregar','Eliminar' o 'Continuar' con una cuenta: ");
            dato1=linea.next();

            switch (dato1){
                case "Agregar":
                    System.out.println("Digite el numero de la nueva linea: ");
                    String nroId=linea.next();
                    usuario.setId(nroId);
                    System.out.println("Nombre del usuario: ");
                    String nombreUsuario=linea.next();
                    usuario.setNombreCompleto(nombreUsuario);
                    System.out.println("Tipo documento: ");
                    String documento=linea.next();
                    usuario.setTipoDocumento(documento);
                    System.out.println("Numero de documento de identidad: ");
                    String numeroDocumento = linea.next();
                    usuario.setNroDocumento(numeroDocumento);
                    usuario.setSaldo(10000);
                    usuarios.put(nroId, usuario);


                    break;
                case "Eliminar":
                    System.out.println("Digite el numero de la cuenta a eliminar: ");
                    String nroId2=linea.next();
                    usuario.revomeUsuario(nroId2);
                    System.out.println("La cuenta ha sido eliminada con exito.");
                    break;

            }
        }
        String lineaDigitada = null;
        
        while (!"Finalizar".equals(lineaDigitada)){
            System.out.println("Desea 'Consultar', 'Depositar' o 'Retirar' saldo de su cuenta, o 'Finalizar': ");
            String lineaDigitada1=linea.next();
            lineaDigitada = lineaDigitada1;
            
            System.out.println("Digite el numero de su cuenta: ");
            String dato=linea.next();
            System.out.println("Digite la fecha(dd/mm/aa): ");
            String fecha=linea.next();
            System.out.println("Digite el pais: ");
            String pais=linea.next();
            Cajero nuevoCajero=usuarios.get(dato);
            

            switch (lineaDigitada1){
                case "Consultar":
                    
                    System.out.println("Su saldo es: " + nuevoCajero.getSaldo());
                    System.out.println("La cuenta: "+dato+ ", ha realizado la accion: "+lineaDigitada1 +", desde el pais: "+pais+ ", en la fecha: "+fecha);
                    

                    break;
                case "Depositar":
                    System.out.println("Ingrese la cantidad a depositar: ");
                    int deposito = linea.nextInt();
                    nuevoCajero.agregarSaldo(deposito);
                    System.out.println("La cuenta: "+ dato+ ", ha realizado la accion: "+lineaDigitada1 +", desde el pais: "+pais+ ", en la fecha: "+fecha);
                    
                    
                    break;
                case "Retirar":
                    System.out.println("Ingrese la cantidad del monto a retirar: ");
                    int saldoRetirado=linea.nextInt();
                    nuevoCajero.retirarSaldo(saldoRetirado);
                    System.out.println("La cuenta: "+dato+ " ha realizado la accion: "+lineaDigitada1 +", desde el pais: "+pais+ ", en la fecha: "+fecha);
                    break;

            }
        }
        
    }
    
}
