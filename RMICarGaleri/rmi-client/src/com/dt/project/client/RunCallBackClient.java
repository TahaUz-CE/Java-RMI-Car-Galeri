/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author maske
 */
public class RunCallBackClient {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMICallBackClient client = new RMICallBackClient();
        client.startClient();
        
        Scanner in = new Scanner(System.in);
        
        int yil=0;
        int agirlik=0;
        int fiyat=0;
        
        int seri_no =0;
        int kimlik_no = 0;
        int alici_numarasi = 0;
        
            
        
        String marka = "";
        String model = "";
        String renk = "";
        String alici_ad = "";
        
        String ara="";
        String line="";
        int onay=0;
        
        while(true){
            
            if(onay == 0){
                System.out.println("******************************");
                System.out.println("Araba Galerisine Hoşgeldiniz");
                System.out.println("MENU");
                System.out.println("1.Yeni Araba.\n" +
                "2.Yeni Fatura.\n" +
                "3.Arabayı seri numarasına göre göster.\n" +
                "4.Arabayı markaya göre göster.\n" +
                "5.Faturayı kimlik numarasına göre göster.\n" +
                "6.Faturayı alıcı numarasına göre göster.\n" +
                "0.Bitir.");
                System.out.println("******************************");
                System.out.println("Yapacagınız islemi giriniz : ");
            
                line = in.nextLine();
            }
            
            
            if(line.equals("1")){
                
                System.out.println("Eklemek istediğiniz aracınızın ozelliklerini giriniz.");
                System.out.println("Seri Numarasi :");
                seri_no = in.nextInt();
                System.out.println("Marka :");
                marka = in.next();
                System.out.println("Model :");
                model = in.next();
                System.out.println("Renk :");
                renk = in.next();
                System.out.println("Yil :");
                yil = in.nextInt();
                System.out.println("Agirlik(kg) :");
                agirlik = in.nextInt();
                System.out.println("Fiyat :");
                fiyat = in.nextInt();
                // Txt dosyasina ya da mysql database e kaydet
                
                ara = seri_no+" "+marka+" "+model+" "+renk+" "+yil+" "+agirlik+" "+fiyat;
                
                onay=1;
                
                
            }else if(line.equals("2")){
                System.out.println("Fatura bilgilerini giriniz.");
                System.out.println("Alici Ad :");
                alici_ad = in.next();
                System.out.println("Aracin Seri Numarasi :");
                seri_no = in.nextInt();
                System.out.println("Kimlik No :");
                kimlik_no = in.nextInt();
                System.out.println("Alici Numarasi :");
                alici_numarasi = in.nextInt();
                System.out.println("Fiyat :");
                fiyat = in.nextInt();
                // Txt dosyasina ya da mysql database e kaydet
                
                ara = alici_ad+" "+seri_no+" "+kimlik_no+" "+alici_numarasi+" "+fiyat;
                
                onay=1;
                
                
            }else if(line.equals("3")){
                System.out.println("Aracin Seri Numarasini giriniz.");
                System.out.println("Seri Numarasi :");
                seri_no = in.nextInt();
                System.out.println(seri_no+
                        "'lu arac sistemimizde araniyor lutfen bekleyiniz.");
                //Arayıp tüm özelliklleri bastır.
                
                ara = seri_no+""; 
                
                
            }else if(line.equals("4")){
                System.out.println("Aracin Markasini giriniz.");
                System.out.println("Marka :");
                marka = in.next();
                System.out.println(marka+
                        "'lu arac sistemimizde araniyor lutfen bekleyiniz.");
                //Arayıp tüm özelliklleri bastır.
                
                ara = marka;
                
            }else if(line.equals("5")){
                System.out.println("Faturanizin Kimlik Numarasini giriniz.");
                System.out.println("Kimlik Numarasi :");
                kimlik_no = in.nextInt();
                System.out.println(kimlik_no+
                        "'lu fatura sistemimizde araniyor lutfen bekleyiniz.");
                //Arayıp tüm özelliklleri bastır.
                
                
                ara=kimlik_no+"";
                
                
            }else if(line.equals("6")){
                System.out.println("Faturanizin Alici Numarasini giriniz.");
                System.out.println("Alici Numarasi :");
                alici_numarasi = in.nextInt();
                System.out.println(alici_numarasi+
                        "'lu fatura sistemimizde araniyor lutfen bekleyiniz.");
                
                
                ara=alici_numarasi+"";
                
            }
            
            
            if(line.equalsIgnoreCase("exit")) break;
            
            try{
                
                client.toCarGaleri(line,ara);
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
            
            line="0";
            ara="";
            onay=0;

        }
        
    }
}
