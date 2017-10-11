import java.util.*;

class Flight_Booking_System
{         
    public static int fno;
    public static int no_f;
    public static Flight a1 =new Flight("SpiceJet",1,"Mumbai","Delhi","23.30","3.00",10);
    public static Flight a2 =new Flight("KingFisher",2,"Bangalore","Mumbai","21.30","1.00",10);
    public static Flight a3 =new Flight("AirIndia",3,"Chennai","Myanmar","10.30","15.00",10);
    public static Flight a4 =new Flight("GoAir",4,"Los Angeles","Delhi","8.30","18.00",10);
    public static Flight a5 =new Flight("JetAirways",5,"Mumbai","Ahmedabad","7.00","10.00",10);
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
            {   	
                int opt; 
		Scanner cb=new Scanner(System.in);
                double cdn;
		System.out.println("Enter The Option To Pay  1: Online Payment  2: Pay At Airport");
		opt =cb.nextInt();
		if(opt==1)
		{
                    System.out.println("Enter Debit/Credit Card Number: ");
                    cdn=cb.nextDouble();
                    return(opt);
		}
		else
		{
                    System.out.println("Please Pay At Airport 3 Hours Before Departure Time!!");
                    return(opt);
		}
            }

	public static void main(String args[])
            {          
                int n=0,v5;  
		Scanner s1=new Scanner(System.in);
                Flight_Booking_System.assign();
		passenger p1=new passenger(v);
                System.out.println("Enter 1: Search Flight  2: Book Ticket  3: Payment  4: Cancel Ticket  5: Print Ticket  6: Exit");
                while(n!=6)
                   {   
                        System.out.print("Enter Choice: "); 
                   	n=s1.nextInt();
                        switch(n)
                        {    
                            case 1: p1.SearchFlight();
                                    System.out.println("Enter Flight Number You Want To Book: ");
                                    fno=s1.nextInt();
                                    break;  
                            case 2: no_f=p1.Bookticket();
                                    break;
                            case 3: v5=p1.payment(no_f);
                                    if(v5==1)
                                    System.out.println("Payment Done By Online Service!!");
                                    System.out.println("Have A Safe Journey!!");
                                    break;
                            case 5: ticket tkt=new ticket(v);
                                    tkt.print();
                                    break;
                        }
                   }    
            }       
}

class Flight
{         
    int no_of_ticket;
    String N;
    int Flight_N;
    String sour;
    String Destin;
    String Arrival;
    String Departure;
         
    Flight() 
    {
		
    }
	
    Flight(String Name,int Flight_Num,String source,String Destination,String Arrival_time,String Departure_time,int numberofticket)
	{
		this.N = Name;
		this.Flight_N = Flight_Num;
		this.sour = source;
		this.Destin =Destination;
		this.Arrival = Arrival_time;
		this.Departure= Departure_time;
                this.no_of_ticket=numberofticket;
	}	
}
class passenger extends Flight_Booking_System
{     
	Scanner sc =new Scanner(System.in);
	public static Vector v1= new Vector();
	static String name;
	static int age;
	static String address;
	static String phnum;
	static String nation;
        passenger()
        {
            
        }
	passenger(Vector v)
	{
	  	v1= new Vector(v);
		System.out.println("Enter Name: ");
		name=sc.next();
		System.out.println("Enter Age: ");
		age=sc.nextInt();
		System.out.println("Enter Address: ");
		address=sc.next();
		System.out.println("Enter Phone Number: ");
		phnum=sc.next();
		System.out.println("Enter Nationality: ");
		nation=sc.next();
	}
	public static void SearchFlight()
	{
            Iterator i=v1.iterator();
            System.out.println("Fname       F.NO        f.src       f.des       F.arr       F.dep");
            while(i.hasNext())
                {
                    Flight f=new Flight();
                    f=(Flight)i.next();
                    System.out.println(f.N+"    "+f.Flight_N+"      "+f.sour+"      "+f.Destin+"    "+f.Arrival+"       "+f.Departure);
		}
	}
        public int no_of;
        public int no_of_tickets;
        public int Bookticket()
        {            
            Iterator i=v.iterator();
            while(i.hasNext())
            {
            Flight f=new Flight();
            f=(Flight)i.next();
            if(fno==f.Flight_N)
            {
                no_of_tickets=f.no_of_ticket;
            }
            }
            int seattype,nofseat;
            System.out.println("How Many Tickets You Want To Book: ");
            no_of=sc.nextInt();
            if(no_of>no_of_tickets)
            {
                System.out.println("Not Enough Tickets!!!!");
                System.out.println(no_of_tickets+" Tickets Remaining.");
            }
            else
            {
                while(i.hasNext())
                {
                    Flight f=new Flight();
                    f=(Flight)i.next();
                    if(fno==f.Flight_N)
                    {
                        f.no_of_ticket-=no_of;
                    }
                }
                no_of_tickets =no_of_tickets-  no_of;
                System.out.println("Number Of Ticket Left: "+no_of_tickets);
                System.out.println("Type Of Seat Enter 1: Window 2: Middle 3: Outer ");
                seattype=sc.nextInt();
                switch(seattype)
                {
                case 1: System.out.println("How Many Window Seats Of "+no_of+" Seats");
                        nofseat=sc.nextInt();
                        break;
                case 2: System.out.println("How Many Middle seats Of "+no_of+" Seats");
                        nofseat=sc.nextInt();
                        break;
                case 3: System.out.println("How Many Outer Seats Of "+no_of+" Seats");
                        nofseat=sc.nextInt();
                        break;
                }
            }
            return(no_of);
        }
        public void Cancelticket()
        {
            
        }
        public static int tp;
	public static int payment(int no_of)
	{
            int op,resp=0;
            Scanner bn=new Scanner(System.in);
            System.out.println("Price Of 1 Ticket: 2000");
            tp=no_of*2000;
            System.out.println("Price Of "+no_of+" Tickets: "+tp);
            System.out.println("Want To Pay  Enter 1: Yes 2: No");
            op = bn.nextInt();
            if(op==1)
            {
                resp=Flight_Booking_System.dopay();
            }
            return(resp);
	}
}

class ticket
{
    public Vector v;
    ticket(Vector v)
    {
        this.v = new Vector();
        this.v=v;
    }
    public void print()
    {
        passenger pass=new passenger();
        Flight_Booking_System fb=new Flight_Booking_System();
        System.out.println("Your Ticket\n");
        Iterator i=v.iterator();
        while(i.hasNext())
	{
            Flight f=new Flight();
            f=(Flight)i.next();
            if(fb.fno==f.Flight_N)
            {                 
                System.out.println("Flight name: "+f.N+"\nFlight Number: "+f.Flight_N+"\nFight Source: "+f.sour+"\nFlight Destination: "+f.Destin+"\nFlight Arrival Time: "+f.Arrival+"\nFlight Departure Time: "+f.Departure);
		System.out.println("Passenger Name: "+pass.name);
		System.out.println("Passenger Age: "+pass.age);
		System.out.println("Passenger Address: "+pass.address);
		System.out.println("Passenger Phone Number: "+pass.phnum);
		System.out.println("Passenger Nationality: "+pass.nation);
                System.out.println("Amount Paid: "+pass.tp);
		System.out.println("Number Of Tickets: "+fb.no_f);
                break;
            }
        }
    }
} 
