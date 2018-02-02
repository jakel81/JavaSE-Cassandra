/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassandra2017;

import com.datastax.driver.core.*;
import java.util.List;

/**
 *
 * @author Jo
 */
public class ListeColonnes {

    public static void main(String[] args) {
        Cluster cluster;
        Session session;
        ColumnMetadata columnMetadata;

        try {
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
          
            Metadata metadata = cluster.getMetadata();
            List<ColumnMetadata> listeColonnes = metadata.getKeyspace("cours").getTable("pays").getColumns();
            
            for(int i = 0; i <= listeColonnes.size(); i++){
                columnMetadata = listeColonnes.get(i);
                String lsNomColonne = columnMetadata.getName();
                System.out.println(lsNomColonne);
            }
                  

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
