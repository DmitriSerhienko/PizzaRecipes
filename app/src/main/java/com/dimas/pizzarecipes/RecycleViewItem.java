package com.dimas.pizzarecipes;

public class RecycleViewItem {
    private int imResourse;
    private String text1;
    private String text2;

    public RecycleViewItem(int imResourse, String text1, String text2) {
        this.imResourse = imResourse;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImageRes(){
        return imResourse;
    }
    public String getText1(){
        return text1;
    }
    public String getText2(){
        return text2;
    }
}
