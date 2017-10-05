import java.util.*;

class Flight_Booking_System
{
	public static Flight a1 =new Flight("Spicejet",1,"mumbai","Delhi","23.30","3.00");
	public static Flight a2 =new Flight("KingFisher",2,"bangalore","Mumbai","21.30","1.00");
    	public static Flight a3 =new Flight("AirIndia",3,"chennai","Myanmar","10.30","15.00");
	public static Flight a4 =new Flight("GoAir",4,"los_angeles","Delhi","8.30","18.00");
	public static Flight a5 =new Flight("Jet_Airways",5,"mumbai","ahmedabad","7.00","10.00");

	public static  Vector v=new Vector();
	static void assign()
	{
	v.addElement(a1);
	v.addElement(a2);
	v.addElement(a3);
	v.addElement(a4);
	v.addElement(a5);
	}
	public static void main(String args[])
	{
		Flight_Booking_System.assign();
		passenger p1=new passenger(v);
		p1.SearchFlight();
	}
	
}

class Flight
{
	    	static String N;
		static int Flight_N;
		static String sour;
		static String Destin;
		static String Arrival;
		static String Departure;
		
	Flight(String Name,int Flight_Num,String source,String Destination,String Arrival_time,String Departure_time)
	{
		N = Name;
		Flight_N = Flight_Num;
		sour = source;
		Destin =Destination;
		Arrival = Arrival_time;
		Departure= Departure_time;
		
	}
}
class passenger
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
	{/*
		Enumeration e=v1.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement()+"");
		}
		*/
	   Flight_Booking_System f=new Flight_Booking_System();
		for(int i=0;i<v1.size();i++)
		{
			
			System.out.println(f.v1(i));			
		}
		/*
		Flight_Booking_System f1=new Flight_Booking_System();
		Vector v2=new Vector(f1.v);
		for(int i=0;i<v2.size();i++)
		{
		*/	
	}
}
