package com.example.ode_06;

import java.io.*;

public class Main {
    public static void main(String[] args){
        File image = new File("C:/Users/sardo/Desktop/Studium/3. Semester/Objektorientierte Dienstleistungen/Projects/ODE_06/pic.jpeg");

        System.out.println("Path: " + image.getAbsolutePath());
        System.out.println("Exists: " + image.exists());
        System.out.println("Is file : " + image.isFile());
        System.out.println("Is directory: " + image.isDirectory());
        System.out.println("Name: " + image.getName());
        System.out.println("Path as stored: " + image.getPath());
        System.out.println("Can read: " + image.canRead());
        System.out.println("Can write: " + image.canWrite());
        System.out.println("Size in bytes: " + image.length() + "\n");


        File directory = image.getParentFile();

        System.out.println("Parent directory: " + directory.getAbsolutePath());
        System.out.println("Exists: " + directory.exists());
        System.out.println("Is file: " + directory.isFile());
        System.out.println("Is directory: " + directory.isDirectory());

        //Infos nicht nur auf Terminal ausgeben, sondern auch in einen txt File schreiben mithilfe FileWriter und BufferedWriter
        File output = new File("file-info.txt");
        BufferedWriter writer = null;

        try {
            FileWriter out = new FileWriter(output);
            writer = new BufferedWriter(out);

            writer.write("FILE INFORMATION\n");
            writer.write("Name " + image.getName() + "\n");
            writer.write("Path: " + image.getPath() + "\n");
            writer.write("Absolute Path: " + image.getAbsolutePath() + "\n");
            writer.write("Exists: " + image.exists() + "\n");
            writer.write("Is file: " + image.isFile() + "\n");
            writer.write("Is directory: " + image.isDirectory() + "\n");
            writer.write("Can read: " + image.canRead() + "\n");
            writer.write("Can write: " + image.canWrite() + "\n");
            writer.write("Size in bytes: " + image.length() + "\n");

            writer.write("- - - - - - - - - - - - -\n");

            writer.write("DIRECTORY INFORMATION\n");
            writer.write("Parent directory: " + directory.getAbsolutePath() + "\n");
            writer.write("Exists: " + directory.exists() + "\n");
            writer.write("Is file: " + directory.isFile() + "\n");
            writer.write("Is directory: " + directory.isDirectory() + "\n");


        } catch (IOException e){
            System.out.println("Error while writing file.");
        } finally {
            try {
                if (writer != null){
                    writer.close();
                }
            } catch (IOException e){
                System.out.println("Error while closing file.");
            }
        }

        System.out.println("Output file: " + output.getAbsolutePath());

        FileInputStream input = null;

        try {
            input = new FileInputStream(image);
            int current = input.read();
            System.out.println("First byte: " + current);
        }catch (IOException e){
            System.out.println("Error while reading file.");
        }finally {
            try {
                if (input != null){
                    input.close();
                }
            }catch (IOException e){
                System.out.println("Error while closing input stream.");
            }
        }
    }
}
