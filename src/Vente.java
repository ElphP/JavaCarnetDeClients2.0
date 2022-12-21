
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FiercePC
 */
public class Vente implements Serializable{
    String prix;
    String date;
    
    public Vente( String date ,String prix)  {
        this.prix = prix;
        this.date = date;
}
}
