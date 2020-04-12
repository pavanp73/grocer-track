package com.pavan.track.models;

import java.io.Serializable;

public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1225094972577541556L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'';
    }
}
