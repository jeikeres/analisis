/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.io.*;
import java.util.*;

/**
 *
 * @author Jake
 */
public class Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String glamoroso ="";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Puzzle 8");
        System.out.print("  _______________________________                     _______________________________\n");
        System.out.print("  |         |         |         |                     |         |         |         |\n ");
        System.out.print(" |  (0,0)  |  (0,1)  |  (0,2)  |                     |    1    |    2    |    3    |\n");
        System.out.print("  |         |         |         |                     |         |         |         |\n");
        System.out.print("   -----------------------------                       -----------------------------\n");
        System.out.print("  |         |         |         |                     |         |         |         |\n ");
        System.out.print(" |  (1,0)  |  (1,1)  |  (1,2)  |      ----->         |    4    |    5    |    6    |\n");
        System.out.print("  |         |         |         |                     |         |         |         |\n");
        System.out.print("   -----------------------------                       -----------------------------\n");
        System.out.print("  |         |         |         |                     |         |         |         |\n ");
        System.out.print(" |  (2,0)  |  (2,1)  |  (2,2)  |                     |    7    |    8    |    0    |\n");
        System.out.print("  |         |         |         |                     |         |         |         |\n");
        System.out.print("   -----------------------------                       -----------------------------\n");
        
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
            System.out.println("Ingrese el número que desea que vaya en la posición (" +i+","+j+") : " );
            String aux = sc.next();
            glamoroso = glamoroso + aux;
            }
        }

       
        Puzzle8 e = new Puzzle8();                              
        e.add(glamoroso, null);                                               

        while(!e.nodos.isEmpty()){
            String currentState = e.nodos.remove();
            e.up(currentState);                                       
            e.down(currentState);                                   
            e.left(currentState);                                   
            e.right(currentState);                         
        }
       
    }
    
}
