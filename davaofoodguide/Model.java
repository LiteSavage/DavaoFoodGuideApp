package com.example.davaofoodguide;

public class Model {

    private int id;
    private byte[] proavatar;
    private String username;
    private String dessy;
    private String linkz;





    //constructor

    public Model(int id, byte[] proavatar, String username, String dessy, String linkz){
        this.id = id;
        this.proavatar = proavatar;
        this.username = username;
        this.dessy = dessy;
        this.linkz = linkz;
    }

    //getter and setter method

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public byte[] getProavatar() {
        return proavatar;
    }

    public void setProavatar(byte[] proavatar) {
        this.proavatar = proavatar;
    }

    public String getUsername() {
        return username;
    }
    public String getDessy() {
        return dessy;
    }
    public String getLinkz() {
        return linkz;
    }


}
