
package queuingcinema;


public class Counter2 {
    
    Queue a;
    char ID;
    int time;
    int endingTime;
    
   public Counter2(Queue a,char ID,int time){
   this.a=a;
   this.ID=ID;
   this.time=time;
   }
   
   public void setEndingTime(int endingTime){
   
   this.endingTime=endingTime;
   }
   
   public int getEndingTime(){
   return endingTime;
   }
   
  
}
