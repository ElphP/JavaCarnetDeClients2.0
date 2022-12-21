/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.Serializable;
import java.util.ArrayList;


        

/**
 *
 * @author FiercePC
 */
public class Client implements Serializable{
    protected String pseudo;
   public ArrayList<Vente> listVentes;
   
   public Client()  {
       
   }
    
    public Client(String pseudo)  {
        this.pseudo = pseudo;
        listVentes = new ArrayList<>();
    } 

    
}
    
