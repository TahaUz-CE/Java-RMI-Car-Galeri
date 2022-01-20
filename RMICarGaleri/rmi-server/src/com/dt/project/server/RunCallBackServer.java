/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.server;

import com.dt.project.api.CarGaleriCallBackServer;
import java.rmi.AlreadyBoundException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author maske
 */
public class RunCallBackServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        CarGaleriCallBackServer server = new CarGaleriCallBackServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("Server Started !");
    }
}
