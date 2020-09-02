package com.licoricegame.webapp.model;

import java.util.Objects;

public class Resume {


    public String uuid;
    //Уникальный идент-ор

    public String getUuid() {
        return uuid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    @Override
    public String toString(){return uuid;}
}
