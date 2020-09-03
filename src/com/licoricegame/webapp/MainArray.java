package com.licoricegame.webapp;

import com.licoricegame.webapp.model.Resume;
import com.licoricegame.webapp.storage.ArrayStorage;
import com.licoricegame.webapp.storage.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainArray {
    private final static Storage arrayStorage = (Storage) new ArrayStorage();
    private static long TIMEOUT;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Resume r;

        while(true){

            System.out.println("Введите одну из команд:\n /list\n /save\n /delete\n /get\n /update\n /clear\n /exit\n");
            String[] params = reader.readLine().trim().toLowerCase().split("\n");

            if(params.length < 1 || params.length > 2){
                System.out.println("Неверная команда");
                continue;
            }

            String uuid = null;
            if(params.length == 2){
                uuid = params[1].intern();
            }

            switch(params[0]){
                case "list":
                    TIMEOUT = System.nanoTime();
                    printAll();
                    break;
                case "size":
                    TIMEOUT = System.nanoTime();
                    System.out.println(arrayStorage.size());
                    break;
                case "save":
                    TIMEOUT = System.nanoTime();
                    r = new Resume(uuid);
                    arrayStorage.save(r);
                    printAll();
                    break;
                case "update":
                    TIMEOUT = System.nanoTime();
                    r = new Resume(uuid);
                    arrayStorage.update(r);
                    printAll();
                    break;
                case "delete":
                    TIMEOUT = System.nanoTime();
                    arrayStorage.delete(uuid);
                    printAll();
                    break;
                case "get":
                    TIMEOUT = System.nanoTime();
                    System.out.println(arrayStorage.get(uuid));
                    printAll();
                    break;
                case "clear":
                    TIMEOUT = System.nanoTime();
                    arrayStorage.clear();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда");
                    break;

            }

        }

    }

    private static void printAll() {
        for (Resume r : arrayStorage.getAll()) System.out.println(r);
    }
}

