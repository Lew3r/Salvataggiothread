package com.lezione.runnable;

import com.lezione.SaveManager;
import com.lezione.classi.Savable;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Save implements Runnable {
 private SaveManager saveManager;
 private ArrayList<Savable> savables;

    public Save(SaveManager savemanager, ArrayList<Savable> savables) {
        this.saveManager=savemanager;
        this.savables=savables;
    }

    public void run()
    {
        try {
            this.saveManager.salvaSuFile(savables);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
