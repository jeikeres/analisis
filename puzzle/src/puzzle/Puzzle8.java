/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

/**
 *
 * @author Jake
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Puzzle8 {

    Queue<String> nodos = new LinkedList<String>();  
    Map<String,Integer> estado_inicio = new HashMap<String, Integer>();
    Map<String,String> estadoHistorico = new HashMap<String,String>();
    Integer i = 0;
    Integer j[] = new Integer[50];
   
       void add(String estadoNuevo, String estadoAntiguo){
       
        if(!estado_inicio.containsKey(estadoNuevo)){
            int nivel = estadoAntiguo == null ? 0 : estado_inicio.get(estadoAntiguo) + 1;
            estado_inicio.put(estadoNuevo, nivel);
            nodos.add(estadoNuevo);
            estadoHistorico.put(estadoNuevo, estadoAntiguo);
           
            i += 1;
           
        }

    }
  
    void up(String currentState){//ARRIBA
        int a = currentState.indexOf("0");
        if(a>2){
            String nextState = currentState.substring(0,a-3)+"0"+currentState.substring(a-2,a)+currentState.charAt(a-3)+currentState.substring(a+1);
            Verifica(currentState, nextState);
        }
    }

    void down(String currentState){//ABAJO
        int a = currentState.indexOf("0");
        if(a<6){
            String nextState = currentState.substring(0,a)+currentState.substring(a+3,a+4)+currentState.substring(a+1,a+3)+"0"+currentState.substring(a+4);
            Verifica(currentState, nextState);
        }
    }
    void left(String currentState){//IZQUIERDA
        int a = currentState.indexOf("0");
        if(a!=0 && a!=3 && a!=6){
            String nextState = currentState.substring(0,a-1)+"0"+currentState.charAt(a-1)+currentState.substring(a+1);
            Verifica(currentState, nextState);
        }
    }
    void right(String currentState){//DERECHA
        int a = currentState.indexOf("0");
        if(a!=2 && a!=5 && a!=8){
            String nextState = currentState.substring(0,a)+currentState.charAt(a+1)+"0"+currentState.substring(a+2);
            Verifica(currentState, nextState);
        }
    }

    private void Verifica(String oldState, String estadoNuevo) {
        add(estadoNuevo, oldState);
        if(estadoNuevo.equals("123456780")) {
            System.out.println("------------------------------------");
            System.out.println("Estados");
            System.out.println("------------------------------------");
            int contador = 1;
            String estadoTrazado = estadoNuevo;
            while (estadoTrazado != null) {
                System.out.println("-------------------------------------------------------");
                System.out.println("Estado : "+contador);
                printPuzzle(estadoTrazado);
                System.out.println("-------------------------------------------------------");
                contador++;
                estadoTrazado = estadoHistorico.get(estadoTrazado);
            }
            System.out.println("------------------------------------------------------------");
            System.out.println("SOLUCIÓN GLAMOROSA");
            System.out.println("Estado Final - Nivel :"+estado_inicio.get(estadoNuevo)+" Nodos Leidos: " + i);
            System.out.println("------------------------------------------------------------");
            System.exit(0);
        }
    }
   
    private void printPuzzle(String puzzle) {
        System.out.println("-------");
        System.out.println("|"+puzzle.substring(0,1)+"|"+ puzzle.substring(1,2)+"|"+ puzzle.substring(2,3)+"|");
        System.out.println("|"+puzzle.substring(3,4)+"|"+ puzzle.substring(4,5)+"|"+ puzzle.substring(5,6)+"|");
        System.out.println("|"+puzzle.substring(6,7)+"|"+ puzzle.substring(7,8)+"|"+ puzzle.substring(8,9)+"|");
        System.out.println("-------");
    }

}
