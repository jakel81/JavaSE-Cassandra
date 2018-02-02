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
public class InsertPaysBis {
    
    public static void main(String[] args) {
        Cluster cluster;
        Session session;
        
        try{
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
            session = cluster.connect("cours");
            
            PreparedStatement lpst = session.prepare("INSERT INTO pays(id_pays, nom_pays) VALUES (?, ?)");
            BoundStatement lbst = lpst.bind("gb", "Gambie");
            ResultSet lrs = session.execute(lbst);
            
                System.out.println("Le pays a été inséré !!");
                       
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
