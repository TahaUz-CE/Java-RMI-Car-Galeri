/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.server;

import com.dt.project.api.CarGaleriCallBackClient;
import com.dt.project.api.CarGaleriCallBackServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maske
 */
public class CarGaleriCallBackServerImpl implements CarGaleriCallBackServer{
    
    public String result;
    
    public CarGaleriCallBackServerImpl() throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String toCarGaleri(String line,String ara, CarGaleriCallBackClient client){
            
            Scanner in = new Scanner(System.in);
            
            
            String words[] = ara.split(" ");
           
            
            ArrayList <String> arabaKelime = new ArrayList <>();
            ArrayList <String> faturaKelime = new ArrayList <>();
            
            
            
            
            for(String token : words) {
                arabaKelime.add(token);
                faturaKelime.add(token);
            }
            
            if(line.equals("1")){
                
                // Txt dosyasina ya da mysql database e kaydet
                
                try {
                    Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cargaleri", "root", "12345");
                    String sorgu = "INSERT INTO arabalar values('"+arabaKelime.get(0)+"','" + arabaKelime.get(1) + "','" + arabaKelime.get(2) + "','" + arabaKelime.get(3) + "','" + arabaKelime.get(4) + "','"+arabaKelime.get(5)+"','"+arabaKelime.get(6)+"')";
                    Statement sta = myConn.createStatement();
                    System.out.println("Sorgulaniyor lutfen bekleyiniz.");
                    TimeUnit.SECONDS.sleep(3);
                    int x = sta.executeUpdate(sorgu);
                    if(x == 0){
                        System.out.println("Araba zaten var !");
                    }else{
                        System.out.println("Araba basariyla databasede olusturuldu !");
                        result = "Araba basariyla databasede olusturuldu !";
                        TimeUnit.SECONDS.sleep(3);
                    }
                } catch (Exception e) {
                
                    if(e.getMessage().indexOf("Duplicate") != -1){
                        System.out.println("Bu Araba zaten var !");
                    }else{
                        System.out.println("Data Base Hatasi : "+e.getMessage());
                    }
                
                }
                
                
            }else if(line.equals("2")){
                
                // Txt dosyasina ya da mysql database e kaydet
                
                try {
                    Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cargaleri", "root", "12345");
                    String sorgu = "INSERT INTO faturalar values('"+faturaKelime.get(0)+"','" + faturaKelime.get(1) + "','" + faturaKelime.get(2) + "','" + faturaKelime.get(3) + "','" + faturaKelime.get(4) + "')";
                    Statement sta = myConn.createStatement();
                    System.out.println("Sorgulaniyor lutfen bekleyiniz.");
                    TimeUnit.SECONDS.sleep(3);
                    int x = sta.executeUpdate(sorgu);
                    if(x == 0){
                        System.out.println("Fatura zaten var !");
                    }else{
                        System.out.println("Fatura basariyla databasede olusturuldu !");
                        result = "Fatura basariyla databasede olusturuldu !";
                        TimeUnit.SECONDS.sleep(3);
                    }
                } catch (Exception e) {
                
                    if(e.getMessage().indexOf("Duplicate") != -1){
                        System.out.println("Bu Fatura zaten var !");
                    }else{
                        System.out.println("Data Base Hatasi : "+e.getMessage());
                    }
                
                }
                
                
            }else if(line.equals("3")){
                
                //Arayıp tüm özelliklleri bastır.
                
                try {
                    
                    Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cargaleri", "root", "12345");
                    String sorgu = "SELECT * FROM arabalar WHERE serino LIKE \""+ara+"\"";
                    Statement sta = myConn.createStatement();
                    System.out.println("Sorgulaniyor lutfen bekleyiniz.Eger yanit alamadiysaniz girdiginiz degeri kontrol ediniz.");
                    TimeUnit.SECONDS.sleep(3);
                    ResultSet myRs = sta.executeQuery(sorgu);
                    
                    while (myRs.next()) {
                        System.out.println("Seri Numarasi : "+myRs.getInt("serino"));
                        System.out.println("Marka : "+myRs.getString("marka"));
                        System.out.println("Model : "+myRs.getString("model"));
                        System.out.println("Renk : "+myRs.getString("renk"));
                        System.out.println("Yil : "+myRs.getInt("yil"));
                        System.out.println("Agirlik(kg) : "+myRs.getInt("agirlik"));
                        System.out.println("Fiyat : "+myRs.getInt("fiyat"));
                        
                        result = "Seri No : "+myRs.getInt("serino")+
                                " Marka : "+myRs.getString("marka")+
                                " Model : "+myRs.getString("model")+
                                " Renk : "+myRs.getString("renk")+
                                " Yil : "+myRs.getInt("yil")+
                                " Agirlik(kg) : "+myRs.getInt("agirlik")+
                                " Fiyat : "+myRs.getInt("fiyat");
                        System.out.println(result);
                        
                    }
                    
                } catch (Exception e){
                    System.out.println(e);
                }
                
                
            }else if(line.equals("4")){
                
                //Arayıp tüm özelliklleri bastır.
                try {
                    
                    Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cargaleri", "root", "12345");
                    String sorgu = "SELECT * FROM arabalar WHERE marka LIKE \""+ara+"\"";
                    Statement sta = myConn.createStatement();
                    System.out.println("Sorgulaniyor lutfen bekleyiniz.Eger yanit alamadiysaniz girdiginiz degeri kontrol ediniz.");
                    TimeUnit.SECONDS.sleep(3);
                    ResultSet myRs = sta.executeQuery(sorgu);
                    
                    while (myRs.next()) {
                        System.out.println("Seri Numarasi : "+myRs.getInt("serino"));
                        System.out.println("Marka : "+myRs.getString("marka"));
                        System.out.println("Model : "+myRs.getString("model"));
                        System.out.println("Renk : "+myRs.getString("renk"));
                        System.out.println("Yil : "+myRs.getInt("yil"));
                        System.out.println("Agirlik(kg) : "+myRs.getInt("agirlik"));
                        System.out.println("Fiyat : "+myRs.getInt("fiyat"));
                        
                        result = "Seri No : "+myRs.getInt("serino")+
                                " Marka : "+myRs.getString("marka")+
                                " Model : "+myRs.getString("model")+
                                " Renk : "+myRs.getString("renk")+
                                " Yil : "+myRs.getInt("yil")+
                                " Agirlik(kg) : "+myRs.getInt("agirlik")+
                                " Fiyat : "+myRs.getInt("fiyat");
                        System.out.println(result);
                    }
                    
                } catch (Exception e){
                    System.out.println(e);
                }
                
                
            }else if(line.equals("5")){
                
                //Arayıp tüm özelliklleri bastır.
                
                try {
                    
                    Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cargaleri", "root", "12345");
                    String sorgu = "SELECT * FROM faturalar WHERE kimlikno LIKE \""+ara+"\"";
                    Statement sta = myConn.createStatement();
                    System.out.println("Sorgulaniyor lutfen bekleyiniz.Eger yanit alamadiysaniz girdiginiz degeri kontrol ediniz.");
                    TimeUnit.SECONDS.sleep(3);
                    ResultSet myRs = sta.executeQuery(sorgu);
                    
                    while (myRs.next()) {
                        System.out.println("Isim : "+myRs.getString("isim"));
                        System.out.println("Arac Seri No : "+myRs.getInt("aracserino"));
                        System.out.println("Kimlik No : "+myRs.getInt("kimlikno"));
                        System.out.println("Alici No : "+myRs.getInt("alicino"));
                        System.out.println("Fiyat : "+myRs.getInt("fiyat"));
                        
                        result = "Isim : "+myRs.getString("isim")+
                                " Arac Seri No : "+myRs.getInt("aracserino")+
                                " Kimlik No : "+myRs.getInt("kimlikno")+
                                " Alici No : "+myRs.getInt("alicino")+
                                " Fiyat : "+myRs.getInt("fiyat");
                        System.out.println(result);
                    }
                    
                    
                } catch (Exception e){
                    System.out.println(e);
                }
                
                
                
            }else if(line.equals("6")){
                
                //Arayıp tüm özelliklleri bastır.
                
                try {
                    
                    Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cargaleri", "root", "12345");
                    String sorgu = "SELECT * FROM faturalar WHERE alicino LIKE \""+ara+"\"";
                    Statement sta = myConn.createStatement();
                    System.out.println("Sorgulaniyor lutfen bekleyiniz.Eger yanit alamadiysaniz girdiginiz degeri kontrol ediniz.");
                    TimeUnit.SECONDS.sleep(3);
                    ResultSet myRs = sta.executeQuery(sorgu);
                    
                    while (myRs.next()) {
                        System.out.println("Isim : "+myRs.getString("isim"));
                        System.out.println("Arac Seri No : "+myRs.getInt("aracserino"));
                        System.out.println("Kimlik No : "+myRs.getInt("kimlikno"));
                        System.out.println("Alici No : "+myRs.getInt("alicino"));
                        System.out.println("Fiyat : "+myRs.getInt("fiyat"));
                        
                        result = "Isim : "+myRs.getString("isim")+
                                " Arac Seri No : "+myRs.getInt("aracserino")+
                                " Kimlik No : "+myRs.getInt("kimlikno")+
                                " Alici No : "+myRs.getInt("alicino")+
                                " Fiyat : "+myRs.getInt("fiyat");
                        
                        System.out.println(result);
                    }
                    
                } catch (Exception e){
                    System.out.println(e);
                }
                
              
                
            }
            
            
            arabaKelime.removeAll(arabaKelime);
            faturaKelime.removeAll(faturaKelime);
            
        //String result = str.toUpperCase();
        // heavy calculation here
        
        try{
            Thread.sleep(2000);
        } catch (InterruptedException ignored){}
        if(!result.equals("")){
            try {
                client.cargaleriResult(result);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
       return result;
    }
    


    
}