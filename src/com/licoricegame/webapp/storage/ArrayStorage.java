package com.licoricegame.webapp.storage;

import com.licoricegame.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArraysStorage {

    @Override
    protected void fillDeletedElement(int index) {

    }

    @Override
    protected void insertElement(Resume r, int index){
        storage[size] = r;
    }

    protected int getIndex(String uuid) {

        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {

                return i;
            }
        }
        return -1;
    }
}
