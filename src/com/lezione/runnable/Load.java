package com.lezione.runnable;

import com.lezione.LoadManager;
import com.lezione.classi.Savable;

import java.util.ArrayList;

public class Load implements Runnable {
    private LoadManager loadManager;
    private String pathName;
    ArrayList<Savable> savable;

    public Load(LoadManager loadManager,ArrayList<Savable> savable,String pathName) {
        this.loadManager = loadManager;
        this.pathName=pathName;
        this.savable=savable;
    }

    public void run()
    {
        try {
            loadManager.caricaDaFile(this.savable,this.pathName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}