
package queuingcinema;


public class Counter {
    
    Queue a;
    char ID;
    static int ID2;
    int processTime;
    static int NoOfCustomer=0;
    Customer temp;
    static Counter[] counter;
    static int x;
    static int y;
    
    public Counter(Queue a){
    this.a=a;
    counter=initialCreat();
    process();

    }
    
    public Counter(Queue a,char ID,int processTime){
    this.a=a;
    this.ID=ID;
    this.processTime=processTime;
    }
    
    public Counter[] initialCreat(){
    Counter [] counter= new Counter[4];
    counter [0] = new Counter(a,'A',10);
    counter [1] = new Counter(a,'B',15);
    counter [2] = new Counter(a,'C',30);
    counter [3] = new Counter(a,'D',15);
    return counter;
    }
    
    public Customer calling(){
    temp=a.remove();
    NoOfCustomer++;
    return temp;
    }
    
    public Customer callingVIP(){
    temp=a.removeVIP();
    NoOfCustomer++;
    return temp;
    }
    
    public int arrival(){
    return temp.second;
    }
    
    public int startProcessing(){
 //   if(NoOfCustomer<=4){ 
    return temp.second;
//    else 
//        
//        
//        return counter[ID2].y;
    }
    
     public int endProcessing(){
    
    return startProcessing()+processingTime();
    }
    
    public int processingTime(){
     
     return temp.noTicket*processTime;
     }
    
    public int waitingTime(){
    
    return startProcessing()-arrival();
    } 
    
    public void process(){
    if(QueuingCinema.K<=4)    
    for(int i=0;i<QueuingCinema.K;i++)    
    {counter[i].calling();
     printAll(counter[i]);
    }
    
    else if (QueuingCinema.K>4)
    {
     for(int i=0;i<4;i++)    
    {counter[i].calling();
     printAll(counter[i]);
    }
    for(int i=4;i<QueuingCinema.K;i++)
    {
    counter[min(counter[0],counter[1],counter[2],counter[3])].callingVIP();
    printAll(counter[min(counter[0],counter[1],counter[2],counter[3])]);
    }
    }
    
    }
    
    public int min(Counter a,Counter b,Counter c,Counter d){
   
    
    int first =Math.min(a.endProcessing(), b.endProcessing());
    int second=Math.min(c.endProcessing(), d.endProcessing());
    x = Math.min(first,second);
    
    if(x==a.endProcessing()){
//        ID2= 0;
//        counter[0].y=x;
        return 0;
    }
    
    if(x==b.endProcessing()){
//        ID2 = 1;
//        counter[1].y=x;
        return 1;
    }
    if(x==c.endProcessing()){
//        ID2=2;
//        counter[2].y=x;
        return 2;
    }
//    counter[3].y=x;
//    ID2=3;
    return 3;
    } 
    
    public void printAll(Counter counter){
    System.out.println(counter.NoOfCustomer+" "+counter.arrival()+" "+counter.startProcessing()+
            " "+counter.endProcessing()+" "+counter.processingTime()+" "+
            counter.waitingTime()+" "+counter.temp.memberType+" "+counter.ID);

            }
}
