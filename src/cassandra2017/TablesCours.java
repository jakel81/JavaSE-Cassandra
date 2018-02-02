/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassandra2017;

import com.datastax.driver.core.*;
import java.util.Collection;

/**
 *
 * @author Jo
 */
public class TablesCours {

    public static void main(String[] args) {
        Cluster cluster;

        try {
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
            Metadata metadata = cluster.getMetadata();

            Collection<TableMetadata> tablesList = metadata.getKeyspace("cours").getTables();
            String lsTableName;
            for (TableMetadata tableMetadata : tablesList) {
                lsTableName = tableMetadata.getName();

                System.out.println("Les tables de Cours : " + lsTableName);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
