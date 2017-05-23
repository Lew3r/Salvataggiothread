package com.lezione;

import com.lezione.classi.Savable;
import com.lezione.runnable.Load;
import com.lezione.runnable.Save;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        SaveManager saveManager = new SaveManager();
        LoadManager loadManager = new LoadManager();

        ArrayList<Savable> automobili = new ArrayList<Savable>();
        ArrayList<Savable> persone = new ArrayList<Savable>();
        ArrayList<Savable> folletti = new ArrayList<Savable>();
        ArrayList<Thread> threads = new ArrayList<Thread>();
        Load load=new Load(loadManager,automobili,"com.lezione.classi.Automobile");
        Load load2=new Load(loadManager,persone,"com.lezione.classi.Persona");
        Load load3=new Load(loadManager,folletti,"com.lezione.classi.Folletto");
        Thread thread =new Thread(load);
        Thread thread2 =new Thread(load2);
        Thread thread3 =new Thread(load3);
        threads.add(thread);
        threads.add(thread2);
        threads.add(thread3);
        for(Thread threadgen: threads)
        {
            threadgen.start();
        }
        for(Thread threadgen: threads)
        {
            threadgen.join();
        }
        Save save=new Save(saveManager,automobili);
        Thread threadSalv =new Thread(save);
        threadSalv.start();
        Save save1=new Save(saveManager,folletti);
        Thread threadSalv1 =new Thread(save);
        threadSalv1.start();
        Save save2=new Save(saveManager,persone);
        Thread threadSalv2 =new Thread(save);
        threadSalv2.start();



    }
}

/*
* creare un metodo di salvataggio su file per gli arrayList automobili/persone mantenendolo il più generico possibile,
* in modo che aggiungendo un terzo arraylist le modifiche da apportare debbano essere minime.
*
* Questo sistema dovrà creare dei file di salvataggio in chiusura e dovrà caricarli all'apertura del programma.
* */