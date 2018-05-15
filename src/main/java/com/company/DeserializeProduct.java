package com.company;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Dave on 12/05/2018.
 */
public class DeserializeProduct {
    private static final String SERIALIZED_FILE_NAME = "exploit2.xml";

    public static void main(String[] args){
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        mapper.enableDefaultTyping();
//
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//
//        Product iphoneX = null;
//
//        try {
//            iphoneX = mapper.readValue(new File(SERIALIZED_FILE_NAME), Product.class);
//        }
//        catch (java.io.IOException e){
//            e.printStackTrace();
//        }
//
//        System.out.println(iphoneX);


        /*
        * XMLDeserialize:
        * */

        XMLDecoder decoder = null;

        try{
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: File product.xml not found");
        }

//        Product iphoneX = (Product)decoder.readObject();

        Object iphoneX = decoder.readObject();

        System.out.println(iphoneX);

        if(iphoneX instanceof Product) System.out.println("yes");


    }
}
