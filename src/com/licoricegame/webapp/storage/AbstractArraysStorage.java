package com.licoricegame.webapp.storage;

import com.licoricegame.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArraysStorage implements Storage {


    public static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;


    public void clear() {
        Arrays.fill(storage, 0, size, null);
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

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else if (size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            insertElement(r, index);
            size++;
        }

    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume exist " + uuid + "not exist");
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);


    @Override
    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Error!");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}
