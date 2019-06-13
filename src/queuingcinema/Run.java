
package queuingcinema;




public class Run {
    
    Queue a;
    static int NoOfCustomer=0;
    Customer temp;
    int x;
    char ID;
    int startProcessing;
    int waitingTime;
    int completionTime=0;
    
    Counter2[] counter=new Counter2[4];
    
    public Run(Queue a){
    this.a=a;
    initial();
    printTitle();
    process();
    }
    
  
    public void initial(){
    counter [0] = new Counter2(a,'A',10);
    counter [1] = new Counter2(a,'B',15);
    counter [2] = new Counter2(a,'C',30);
    counter [3] = new Counter2(a,'D',15);  
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
    if(NoOfCustomer<=4){ 
    startProcessing = temp.second;
    waitingTime= startProcessing - arrival();
    return startProcessing; }
    else 
        
     if(counter[ID].getEndingTime()>temp.second){   
    startProcessing = counter[ID].getEndingTime();
     waitingTime= startProcessing - arrival();
     return startProcessing; 
    } else
         
    startProcessing = temp.second;
    waitingTime= startProcessing - arrival();
    return startProcessing; 
    
    }
    
    public int endProcessing(Counter2 a){
    int temp = startProcessing()+processingTime(a);
    a.setEndingTime(temp);
    if(temp>completionTime)
    completionTime = temp; 
    return temp;
    }
    
    public int processingTime(Counter2 a){
     
     return temp.noTicket*a.time;
     }
    
    public int waitingTime(){
    
    return startProcessing()-arrival();
    } 
    
    
    public void process(){
    if(QueuingCinema.K<=4)    
    for(int i=0;i<QueuingCinema.K;i++)    
    {calling();
     printAll(counter[i]);
    }
    
    else if (QueuingCinema.K>4)
    {
     for(int i=0;i<4;i++)    
    {callingVIP();
    if(temp.second!=a.peek().second){
    a.add(Queue.index,temp);
    NoOfCustomer--;
    calling();}    
    printAll(counter[i]);
    }
    for(int i=4;i<QueuingCinema.K;i++)
    {
    int x = min(counter[0],counter[1],counter[2],counter[3]);    
    callingVIP();
    if(counter[x].getEndingTime()<temp.second){
    a.add(Queue.index,temp);
    NoOfCustomer--;
    calling();}
    printAll(counter[min(counter[0],counter[1],counter[2],counter[3])]);
    }
    }
       
        System.out.println("Total Completion Time: "+ completionTime);
        QueuingCinema.test.completion(completionTime);
        QueuingCinema.test.countAverage();
    }
    
    public int min(Counter2 a,Counter2 b,Counter2 c,Counter2 d){
   
    
    int first =Math.min(a.getEndingTime(), b.getEndingTime());
    int second=Math.min(c.getEndingTime(), d.getEndingTime());
    x = Math.min(first,second);
    
    if(x==a.getEndingTime()){
        ID= 0;
//        counter[0].y=x;
        return 0;
    }
    
    if(x==b.getEndingTime()){
        ID = 1;
//        counter[1].y=x;
        return 1;
    }
    if(x==c.getEndingTime()){
        ID=2;
//        counter[2].y=x;
        return 2;
    }
//    counter[3].y=x;//        ID2=2;

    ID=3;
    return 3;
    } 
    
    public void printTitle(){
        System.out.println("|Customer\t"+"|Arrival\t"+"|Start Processing\t"
        +"|End Processing\t\t"+"|Processing Time\t"+"|Waiting Time\t\t"+"|Queue\t\t"+"|Counter\t"+"|");
    }
    
    public void printAll(Counter2 counter){
    System.out.format("|%02d",NoOfCustomer);
//    System.out.println("\t\t|"+" "+arrival()+"\t\t|"+" "+startProcessing()+"\t\t\t|"+
//            " "+endProcessing(counter)+"\t\t\t|"+" "+processingTime(counter)+"\t\t\t|"+" "+
//            waitingTime+"\t\t\t|"+" "+temp.memberType+"\t\t|"+" "+counter.ID+"\t\t|");

    QueuingCinema.test.write(arrival(), startProcessing(), endProcessing(counter), processingTime(counter)
            , waitingTime, temp.memberType, counter.ID);
    QueuingCinema.test.average(waitingTime);

            }
    
}
