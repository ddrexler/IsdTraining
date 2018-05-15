package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SerializeProduct {

    private static final String SERIALIZED_FILE_NAME = "product.json";

    public static void main(String[] args) {

        Category electro = new Category("Electro");
        Category smartphone = new Category("Smartphone");
        smartphone.setParent(electro);

        Product iphoneX = new Product("Apple Iphone X", 1199.99f, "Make all your friends jealous.", "images/products/IphoneX.jpg", smartphone);

        /*
        Jackson
         */

        ObjectMapper mapper = new ObjectMapper();

//        //Object to JSON in file
//        try{
//            mapper.writeValue(new File(SERIALIZED_FILE_NAME), iphoneX);
//        }
//        catch (java.io.IOException e){
//            System.out.println("ERROR: While Creating or Opening the File product.json");
//        }

        //Object to JSON in String
        try{
            System.out.println(mapper.writeValueAsString(iphoneX));
        }
        catch (JsonProcessingException e){
            System.out.println("ERROR: ProcessingException");
        }

        /*
        XMLEncoder:
         */
//        XMLEncoder encoder = null;
//        try{
//            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
//        }
//        catch (FileNotFoundException fileNotFound){
//            System.out.println("ERROR: While Creating or Opening the File product.xml");
//        }
//        encoder.writeObject(iphoneX);
//        encoder.close();
    }

}
