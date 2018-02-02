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
public class SelectOneIdPays {
    
    public static void main(String[] args) {
        Cluster cluster;
        Session session;
        
        try{
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
            session = cluster.connect("cours");
            
            PreparedStatement lpst = session.prepare("SELECT * FROM pays WHERE id_pays = ?");
            BoundStatement lbst = lpst.bind("ln");
            ResultSet lrs = session.execute(lbst);
            
            for (Object objet : lrs)
            System.out.println("Le pays est : " + objet.toString());
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
