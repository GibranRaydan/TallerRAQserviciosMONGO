/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallerservicios;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brown
 */
public class SampleInsert {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public static Paciente add() {
        try {
            MongoClient mongoClient = new MongoClient(HOST, PORT);
            DB db = mongoClient.getDB("sampledb");
            DBCollection coll = db.getCollection("javastuff");
            List<DBObject> kids = new ArrayList<>();
            kids.add(new BasicDBObject("name", "mike"));
            kids.add(new BasicDBObject("name", "faye"));
            DBObject doc = new BasicDBObject("name", "john")
                    .append("age", 35)
                    .append("kids", kids)
                    .append("info",
                            new BasicDBObject("email", "john@mail.com")
                                    .append("phone", "876-134-667"));
            coll.insert(doc);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        return null;
    }

}

