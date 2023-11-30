package com.cgvsu.model;

import java.util.ArrayList;
import java.util.Objects;

public class Polygon {

    private ArrayList<Integer> vertexIndices;
    private ArrayList<Integer> textureVertexIndices;
    private ArrayList<Integer> normalIndices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(vertexIndices, polygon.vertexIndices) && Objects.equals(textureVertexIndices, polygon.textureVertexIndices) && Objects.equals(normalIndices, polygon.normalIndices);
    }

    public Polygon() {
        vertexIndices = new ArrayList<Integer>();
        textureVertexIndices = new ArrayList<Integer>();
        normalIndices = new ArrayList<Integer>();
    }

    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
        this.vertexIndices = vertexIndices;
    }

    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
        this.textureVertexIndices = textureVertexIndices;
    }

    public void setNormalIndices(ArrayList<Integer> normalIndices) {
        this.normalIndices = normalIndices;
    }

    public ArrayList<Integer> getVertexIndices() {
        return new ArrayList<>(vertexIndices);
    }

    public ArrayList<Integer> getTextureVertexIndices() {
        return new ArrayList<>(textureVertexIndices);
    }

    public ArrayList<Integer> getNormalIndices() {
        return new ArrayList<>(normalIndices);
    }
}
