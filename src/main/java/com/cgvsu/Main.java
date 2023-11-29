package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objwriter.ObjWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("3DModels/Faceform/AlexWithTexture/AlexNeutralWrapped.obj");
        String fileContent = Files.readString(fileName);

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());

        String file = "file.obj";
        ObjWriter.write(file, model);


        Path fileName1 = Path.of("file.obj");
        String fileContent1 = Files.readString(fileName1);

        System.out.println("Loading model ...");
        Model model1 = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model1.vertices.size());
        System.out.println("Texture vertices: " + model1.textureVertices.size());
        System.out.println("Normals: " + model1.normals.size());
        System.out.println("Polygons: " + model1.polygons.size());
    }
}
