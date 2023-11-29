package com.cgvsu.objwriter;

import com.cgvsu.math.Vector2f;
import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ObjWriter {
    private static final String OBJ_VERTEX_TOKEN = "v";
    private static final String OBJ_TEXTURE_TOKEN = "vt";
    private static final String OBJ_NORMAL_TOKEN = "vn";
    private static final String OBJ_FACE_TOKEN = "f";
    public static void write(String fileName, Model model) {
        File file = new File(fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println();
        }

        try (PrintWriter printWriter = new PrintWriter(file)) {
            writeVertices(printWriter, model.vertices);
            writeTextureVertices(printWriter, model.textureVertices);
            writeNormals(printWriter, model.normals);
            writePolygons(printWriter, model.polygons);
        } catch (IOException e) {
            throw new ObjWriterException(e.getMessage());
        }
    }
    protected static void writeVertices(PrintWriter pw, ArrayList<Vector3f> vertices) {
        pw.println(OBJ_VERTEX_TOKEN);
        pw.println();
    }

    protected static void writeTextureVertices(PrintWriter pw, ArrayList<Vector2f> textureVertices) {
        pw.println(OBJ_TEXTURE_TOKEN);
        pw.println();
    }

    protected static void writeNormals(PrintWriter pw, ArrayList<Vector3f> normals) {
        pw.println(OBJ_NORMAL_TOKEN);
        pw.println();
    }

    protected static void writePolygons(PrintWriter pw, ArrayList<Polygon> polygons) {
        pw.println(OBJ_FACE_TOKEN);
        pw.println();
    }
}
