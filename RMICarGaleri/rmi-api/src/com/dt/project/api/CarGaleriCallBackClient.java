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
public interface CarGaleriCallBackClient extends Remote{
    void cargaleriResult(String result) throws RemoteException;
}
