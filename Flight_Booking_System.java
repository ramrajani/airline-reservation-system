import java.util.*;

class Flight_Booking_System
{         
    public static int fno;
    public static  int no_f;
   
	public static Flight a1 =new Flight("Spicejet",1,"mumbai","Delhi","23.30","3.00");
	public static Flight a2 =new Flight("KingFisher",2,"bangalore","Mumbai","21.30","1.00");
    	public static Flight a3 =new Flight("AirIndia",3,"chennai","Myanmar","10.30","15.00");
	public static Flight a4 =new Flight("GoAir",4,"los_angeles","Delhi","8.30","18.00");
	public static Flight a5 =new Flight("Jet_Airways",5,"mumbai","ahmedabad","7.00","10.00");

	public static Vector v=new Vector();
	static void assign()
	{
	v.addElement(a1);
	v.addElement(a2);
	v.addElement(a3);
	v.addElement(a4);
	v.addElement(a5);
	}
	public static int dopay()
		{   	int opt; 
		Scanner cb=new Scanner(System.in);
		
		double cdn;
		System.out.println("enter the option to pay :  1:online payment 2:pay at airport");
		opt =cb.nextInt();
		if(opt==1)
		{
	     System.out.println("Enter debit/credit card number");
	     cdn=cb.nextDouble();
	     	return(opt);
		}
		else
		{
			System.out.println("please pay at airport 3 hours before departure time ");
			return(opt);
		}
		
	}

	public static void main(String args[])
	{          int n=0,v5;  
		    
		   Scanner s1=new Scanner(System.in);
                      
		Flight_Booking_System.assign();
		passenger p1=new passenger(v);
                           System.out.println(" ");
                           System.out.println("Enter 1:SearchFlight   2:Book Ticket   3: payment   4:Cancel Ticket  5:Print Ticket    6:Exit" );
                          
                while(n!=6)
                   {   System.out.print("Enter Choice : "); 
                   	  n=s1.nextInt();
                    switch(n)
                         {    
                         	      
                            
                         case 1: p1.SearchFlight();
                                 System.out.println("Enter Flight number u want to book in");
                                 fno=s1.nextInt();
                                       break;  
                         case  2:  no_f=p1.Bookticket();
                                       break;
                         case  3: v5=p1.payment(no_f);
                                  if(v5==1)
                                  System.out.println("payment done by online service");
                                  System.out.println("Have a safe journey");
                                  break;
                         case 5:         	  
                                      
                           }}    
                   }       
	}
	


class Flight
{                     public int no_of_tickets=10;
                 
	    	String N;
		int Flight_N;
		String sour;
		String Destin;
		String Arrival;
		String Departure;
         
		Flight(){
		}
	Flight(String Name,int Flight_Num,String source,String Destination,String Arrival_time,String Departure_time)
	{
		this.N = Name;
		this.Flight_N = Flight_Num;
		this.sour = source;
		this.Destin =Destination;
		this.Arrival = Arrival_time;
		this.Departure= Departure_time;
	}	
	
}
class passenger   extends Flight
{     
	Scanner sc =new Scanner(System.in);
	public static Vector v1= new Vector();
	static String name;
	static int age;
	static String address;
	static double phnum;
	static String nation;
	passenger(Vector v)
	{
	  	v1= new Vector(v);
		System.out.println("Enter Name");
		name=sc.next();
		System.out.println("Enter Age");
		age=sc.nextInt();
		System.out.println("Enter Address");
		address=sc.next();
		System.out.println("Enter Phone Number");
		phnum=sc.nextDouble();
		System.out.println("Enter Nationality");
		nation=sc.next();
	}
	public static void SearchFlight()
	{
	  
		Iterator i=v1.iterator();
        System.out.println("Fname    F.NO  f.src   f.des   F.arr  F.dep");
		while(i.hasNext())
			
					{
			Flight f=new Flight();
			f=(Flight)i.next();
			//System.out.println((Flight)e.next()+"");
			System.out.println(" "+f.N+" "+f.Flight_N+" "+f.sour+" "+f.Destin+" "+f.Arrival+" "+f.Departure);
		
		}
		/*
		Flight f=new Flight("",0,"","","","");
		for(int i=0;i<v1.size();i++)
		{
			f=(Flight)v1(i);
			System.out.println(f.N+" "+f.Flight_N+" "+f.sour+" "+f.Destin+" "+f.Arrival+" "+f.Departure);
		}
		*/
	}

  public int Bookticket()
     {        int seattype,nofseat;
                int no_of;
            System.out.println("how many tickets u want to book");
             no_of=sc.nextInt();
             if(no_of>no_of_tickets)
              {
                System.out.println("not enough tickets");
                System.out.println(no_of_tickets+"  tickets remaining");
              }
             else{
                 
             no_of_tickets =no_of_tickets -  no_of;
             System.out.println("Type of seat enter 1:window 2:middle 3:outer ");
             seattype=sc.nextInt();
             switch(seattype)
                {
                  case 1: System.out.println("how many window seats of "+no_of+" seats");
                             nofseat=sc.nextInt();
                             break;
                  case 2: System.out.println("how many middle seats of "+no_of+" seats");
                             nofseat=sc.nextInt();
                             break;
                  case 3: System.out.println("how many outer seats of "+no_of+" seats");
                             nofseat=sc.nextInt();
                             break;
                }
             }
             return(no_of);
 
}

	public static int payment(int no_of)
	{  	int tp,op,resp=0;
		 Scanner bn=new Scanner(System.in);
		System.out.println("price for ticket one ticket is 2000");
	
		tp=no_of*2000;
		System.out.println("price for "+no_of+" tickets is "+tp );
		System.out.println("WANT TO PAY  Enter 1: yes 2:No");
		op = bn.nextInt();
		if(op==1)
		{
		resp=Flight_Booking_System.dopay();
		}
		
		return(resp);
	}
}
/*
interface tempticket extends passenger
{
	
}
class ticket implements tempticket extends Flight_Booking_System
{
		Iterator i=v1.iterator();
        System.out.println("Fname    F.NO  f.src   f.des   F.arr  F.dep");
		while(i.hasNext())
			
					{
			Flight f=new Flight();
			f=(Flight)i.next();
			if(fno==f.Flight_N)
			{   System.out.println("passenger name: "+(passenger)v1.name));
				System.out.println("Flight name "+f.N+"\nFlight Number: "+f.Flight_N+"\nFight Source  "+f.sour+"\nFlight DEstination "+f.Destin+"\nFlight arrival Time: "+f.Arrival+"\n Flight Departure Time "+f.Departure);
		         System.out.println("passenger name : "+(passenger)v1.name));
		         System.out.println("passenger age  : "+(passenger)v1.age));
		         System.out.println("passenger adder: "+(passenger)v1.address));
		         System.out.println("passenger phnum: "+(passenger)v1.phnum));
		         System.out.println("passenger natn : "+(passenger)v1.nation));
		         System.out.println("amount paid"+tp);
		         System.out.println("no of tickets"+no_f);
		       
		         
		         break;
		         
            }
					}
}
          
   */         
