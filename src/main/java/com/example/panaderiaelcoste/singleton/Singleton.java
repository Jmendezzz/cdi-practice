package com.example.panaderiaelcoste.singleton;

import com.example.panaderiaelcoste.service.ServiceManager;

public class Singleton {

    private static ServiceManager serviceManager = null;
    private Singleton(){

    }
    public static ServiceManager getInstance(){
        if(serviceManager==null){
            serviceManager = new ServiceManager();
        }
        return serviceManager;
    }

}
