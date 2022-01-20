/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author maske
 */
public interface CarGaleriCallBackServer extends Remote{
    String toCarGaleri(String str,String str2, CarGaleriCallBackClient client) throws RemoteException;
}
