/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassandra2017;

import com.datastax.driver.core.*;

/**
 *
 * @author Jo
 */
public class PaysUpdate {
    
    public static void main(String[] args) {
        Cluster cluster;
        Session session;
        try {

            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

            //
            session = cluster.connect("cours");

            session.execute("UPDATE pays SET nom_pays = 'ITALIA' WHERE id_pays = 'it'");

            cluster.close();

            System.out.println("Pays modifié");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } /// main

    
}
