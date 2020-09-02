package com.licoricegame.webapp;

import com.licoricegame.webapp.model.Resume;
import com.licoricegame.webapp.storage.ArrayStorage;


public class MainArray {
    static ArrayStorage arrayStorage = new ArrayStorage();

    public static void main(String[] args){

        Resume r1 = new Resume();
        r1.setUuid("uuid1");

        Resume r2 = new Resume();
        r2.setUuid("uuid2");

        Resume r3 = new Resume();
        r3.setUuid("uuid3");

        Resume r4 = new Resume();
        r4.setUuid("uuid4");


        arrayStorage.save(r1);
        arrayStorage.save(r2);
        arrayStorage.save(r3);
        arrayStorage.save(r4);


        System.out.println(arrayStorage.get(r1.getUuid()));
        System.out.println(arrayStorage.size());
        System.out.println(arrayStorage.get("dummy "));

        printAll();
        arrayStorage.delete(r1.getUuid());
        printAll();
        arrayStorage.getAll();
        printAll();
        arrayStorage.clear();
        printAll();
        arrayStorage.size();
        printAll();
        arrayStorage.getAll();


    }

    private static void printAll() {
        Resume[] all = arrayStorage.getAll();
        for (Resume r : arrayStorage.getAll()) System.out.println(r);
    }
}
