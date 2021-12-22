package com.example.davaofoodguide;

public class CustomList {

    private int mImgResId;
    private String pname, pdescription;

    public CustomList (int imgId, String placename, String placedesc){
        mImgResId = imgId;
        pname = placename;
        pdescription = placedesc;
    }

    public int getmImgResId(){
        return mImgResId;
    }

    public String getPname(){
        return pname;
    }

    public String getPdescription(){
        return pdescription;
    }


}
