package com.licoricegame.webapp.storage;

import com.licoricegame.webapp.model.Resume;

public class ArrayStorage {


    //База резюме в кол-ве 10000 штук.
    //Если резюме меньше, то остальные null

    Resume[] storage = new Resume[10000];

    //Размер ТОЛЬКО non-null в массиве (где есть резюме)
    int size = 0;


    //Сохранить резюме
    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else if (size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }

    }

    //Получить конкретное резюме
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Error!");
            return null;
        }
        return storage[index];
    }


    //Очистить все резюме
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    //Обновить конкретное резюме
    public void update(Resume r) {
        int index = getIndex(r.getUuid());


        if (getIndex(r.uuid) == -1) {
            System.out.println("Resume " + r.uuid + " not exist");
        } else {
            storage[index] = r;
            size++;
        }

    }


    //Удалить конкретное резюме
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume exist " + uuid + "not exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    //Получить ВСЕ резюме
    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    //Получить количество резюме
    public int size() {
        return size;
    }

    private int getIndex(String uuid) {

        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {

                return i;
            }
        }
        return -1;
    }


}
