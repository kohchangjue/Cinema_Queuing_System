package queuingcinema;


public class Customer {
    
    int second;
    String memberType;
    int noTicket;
    
    public Customer(int second, String memberType, int noTicket)
    {
    this.second=second;
    this.memberType=memberType;
    this.noTicket=noTicket;
    }
    
    public String toString(){
    return memberType;
    }
    
}
