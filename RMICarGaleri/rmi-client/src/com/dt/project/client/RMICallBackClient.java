/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.client;

import com.dt.project.api.CarGaleriCallBackClient;
import com.dt.project.api.CarGaleriCallBackServer;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maske
 */
public class RMICallBackClient implements CarGaleriCallBackClient{
    
    private CarGaleriCallBackServer server;
    
    public RMICallBackClient() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }
    
    public void startClient()throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.getRegistry("localhost",1099);
        server = (CarGaleriCallBackServer)registry.lookup("Server");
    
    }
    
    public void toCarGaleri(String argument,String argument1){
        try {
            server.toCarGaleri(argument,argument1, this);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public void cargaleriResult(String result){
        System.out.println("Result > " + result);
    }
}
