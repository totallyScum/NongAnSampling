package com.chen.nongansampling.bean.ui;

public class ListviewBean <T>{
    private int imageSrc;
    private String name;
    private T data;
    private Boolean Complicated;

    public Boolean getComplicated() {
        return Complicated;
    }

    public void setComplicated(Boolean complicated) {
        Complicated = complicated;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
