package com.fja.po;

/**
 * @author ${fujingao}
 * @create 2020-10-01-8:49
 */
public class User {
    private int idd;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.idd = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idd +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return idd;
    }

    public void setId(int id) {
        this.idd = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
