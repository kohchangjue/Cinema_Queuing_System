
package queuingcinema;

import java.util.*;


public class QueuingCinema {
    
    static int K=0;
    static String time;
    static String type;
    static String noTicket;
    static boolean OK = false;
    static Queue a = new Queue();
    static Test test; 
    

    public static void main(String[] args) {
     
      test = new Test(); 
      test.setVisible(true);
    
    
}
    public static void input(){  
    a.offer(new Customer(Integer.valueOf(time),type,Integer.valueOf(noTicket)));
    K++;
    }
    
    public static void start(){
    if(OK==true){
      Run coun = new Run(a);
      }}
    
    public void restart(){
       test = new Test(); 
      test.setVisible(true);
    
    }
}
