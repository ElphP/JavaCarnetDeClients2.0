

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.function.Predicate;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FiercePC
 */
class listClient implements Serializable{
    public static LinkedHashSet<Client>listClient = new LinkedHashSet<>();
    
    
    public static void ajoutClient(Client C)  {
        listClient.add(C);
    }
    
    public static void ajoutClient(String S)  {
        listClient.add(new Client(S));
        
    }
    
    public static DefaultListModel affichListClient(DefaultListModel dlm)  {
         for (Client C: listClient)  {
                    dlm.addElement(C.pseudo);
                }
        return dlm;
    }
    
     public static boolean supprClient(String S)  {
          Predicate<Client> filter =C -> (C.pseudo.equalsIgnoreCase(S));
            boolean value = listClient.removeIf(filter);
           return value;
                    }
         
     public static void enregistrerVente(String dateLivr, String prix, String S)  {
          for( Client C: listClient)   {
            if(C.pseudo.equalsIgnoreCase(S) )  {
                C.listVentes.add(new Vente( dateLivr, prix));
            } 
          }
     }
     
     public static DefaultTableModel afficherVentes(DefaultTableModel T, String S)  {
        T.setRowCount(0);
         for( Client C: listClient)   {
            if(C.pseudo.equalsIgnoreCase(S) )  {
                
                for(int i = 0; i<C.listVentes.size();i++)  {
                String [] row =  new String[2] ;
                row [0] =(C.listVentes.get(i).date);
                row  [1] = (C.listVentes.get(i).prix);
                T.addRow(row );
                }
            }
          }
          return T;
     }
     
     public static DefaultTableModel resetTabl(DefaultTableModel T)  {
         T.setRowCount(0);
         return T;
     }
    
     public static void venteSuppr(String S, int V)  {
        
         
         for( Client C: listClient)   {
            if(C.pseudo.equalsIgnoreCase(S) )  {
                C.listVentes.remove(V);
                }
         }
          
     }
     
    public static void enregistrement()  {
         try {
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listeClient.dat"));
             for (Client C: listClient)  {
                 oos.writeObject(C);
             }
             oos.close();
             JOptionPane.showMessageDialog(null,"La liste a bien été mise à jour.");
         } catch (FileNotFoundException e)  {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
