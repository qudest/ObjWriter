package com.cgvsu.objwriter;

import com.cgvsu.math.Vector2f;
import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;

import java.io.File;
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
            if (!file.exists() && !file.createNewFile()) {
                throw new ObjWriterException("Unable to create the file: " + fileName);
            }
        } catch (IOException e) {
            throw new ObjWriterException(e.getMessage());
        }

        try (PrintWriter printWriter = new PrintWriter(file)) {
            writeVertices(printWriter, model.vertices);
            writeTextureVertices(printWriter, model.textureVertices);
            writeNormals(printWriter, model.normals);
            writePolygons(printWriter, model.polygons);
        } catch (IOException e) {
            throw new ObjWriterException("Error writing to file: " + fileName);
        }
    }
    protected static void writeVertices(PrintWriter pw, ArrayList<Vector3f> vertices) throws IOException {
        for (Vector3f vertex: vertices) {
            pw.println(OBJ_VERTEX_TOKEN + " " + vertex.x + " " + vertex.y + " " + vertex.z);
        }
        pw.println();
    }

    protected static void writeTextureVertices(PrintWriter pw, ArrayList<Vector2f> textureVertices) throws IOException {
        for (Vector2f vertex: textureVertices) {
            pw.println(OBJ_TEXTURE_TOKEN + " " + vertex.x + " " + vertex.y);
        }
        pw.println();
    }

    protected static void writeNormals(PrintWriter pw, ArrayList<Vector3f> normals) throws IOException {
        for (Vector3f normal: normals) {
            pw.println(OBJ_NORMAL_TOKEN + " " + normal.x + " " + normal.y + " " + normal.z);
        }
        pw.println();
    }

    protected static void writePolygons(PrintWriter pw, ArrayList<Polygon> polygons) throws IOException {
        for (Polygon polygon : polygons) {
            ArrayList<Integer> vertexIndices = polygon.getVertexIndices();
            ArrayList<Integer> textureVertexIndices = polygon.getTextureVertexIndices();
            ArrayList<Integer> normalIndices = polygon.getNormalIndices();

            pw.print(OBJ_FACE_TOKEN + " ");
            for (int i = 0; i < vertexIndices.size(); i++) {
                if (!textureVertexIndices.isEmpty()) {
                    pw.print((vertexIndices.get(i) + 1) + "/" + (textureVertexIndices.get(i) + 1));
                } else {
                    pw.print(vertexIndices.get(i) + 1);
                }
                if (!normalIndices.isEmpty()) {
                    if (textureVertexIndices.isEmpty()) {
                        pw.print("/");
                    } else {
                        pw.print("/" + (normalIndices.get(i) + 1));
                    }
                }
                pw.print(" ");
            }
            pw.println();
        }
    }
}
