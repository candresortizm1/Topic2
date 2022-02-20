package com.glb.javaacademy.Topic2.model;

public class Printer {
    private final int id;
    private String name;
    private boolean blackWhite;
    private boolean color;
    private String typePrinter;

    public Printer(int id, String name, boolean color,boolean blackWhite) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.blackWhite = blackWhite;
    }

    public boolean getBlackWhite() {
        return blackWhite;
    }

    public int getId() {
        return id;
    }

    public boolean getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
