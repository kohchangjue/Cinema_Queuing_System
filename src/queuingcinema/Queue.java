
package queuingcinema;

import java.util.*;

public class Queue {

    LinkedList<Customer> a = new LinkedList();
    static int index;
    
    public void offer(Customer cus){
    a.offer(cus);
    }   

    public Customer remove(){
         
    return a.remove();
    }
    
   public Customer removeVIP(){
       
    for(int i=0;i<a.size();i++) {
    if(a.get(i).memberType.equals("V"))   
    {index=i;
    return a.remove(i);
    }
    }   
    return a.remove();
    }

    public int size(){
    return a.size();
    }
    
    public Customer peek(){
    return a.peekFirst();
    }
    
    public void add(int index, Customer cus){
    a.add(index, cus);
    if(a.size()==0)a.addLast(cus);
    }
    
    }
