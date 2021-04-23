/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto6;

import java.util.HashMap;

/**
 *
 * @author ACER
 */
public class Cajero  {
    
    private String nombreCompleto;
    private String id;
    private String nroDocumento;
    private String tipoDocumento;
    private int saldo=0;
    private final int montoMaximo=1000000;
    private final int transPermitidas=3;
    
    public HashMap<Object,Object> usuarios= new HashMap<>();

    
    
    
    
    
    

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String text) {
        this.nombreCompleto = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws CustomException{
        try{
            if(id.length()>=9){
                this.id = id;
            }
            else{
                throw new CustomException("El numero del id debe tener el menos 10 digitos."); 
            }
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
        this.id = id;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String text) {
        this.nroDocumento = text;
        
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String text) {
        this.tipoDocumento = text;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int s) {
        this.saldo = s;
    }


    public int getMontoMaximo() {
        return montoMaximo;
    }

    public int getTransPermitidas() {
        return transPermitidas;
    }
    
    public void revomeUsuario(String a){
        try{
            if(usuarios.containsValue(a)){
                usuarios.remove(a);
            }
            else{
                throw new CustomException("Esta cuenta no existe.");
            }
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
        
    }
    public void agregarUsuario(String usuario,Cajero o)throws CustomException{
        
        usuarios.put(usuario, o);
        
    }
    public void agregarSaldo(int i){
        this.saldo+=i;
    }
    public int consultarSaldo(){
        return this.saldo;
    }
    public void retirarSaldo(int i) throws CustomException{
        try{
            if (i<this.saldo){
                this.saldo-=i;
            }
            else{
                throw new CustomException("Transaccion no permitida, usted excede el monto disponible en su cuenta.");
            }
            
        }catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }
    public HashMap getDiccionario(){
        return usuarios;
    }

    

}
