import java.util.Scanner;
class BankAccount{
int accNumber;
String name;
double balance;
Scanner sc =new Scanner(System.in);
public void getInfo()
{
System.out.println("enter account number");
accNumber=sc.nextInt();
System.out.println("enter account holder name");
name=sc.nextLine();
System.out.println("enter account balance");
balance=sc.nextDouble();
}
public void deposit()
{
System.out.println("enter the deposit amount");
double deposit=sc.nextDouble();
balance+=deposit;
System.out.println("after deposition balance is="+balance);
}
public void withdraw()
{
	System.out.println("enter withdraw amount");
	double withdraw=sc.nextDouble();
	if(withdraw>balance)
		System.out.println("insufficient balance");
	else
	{
		balance-=withdraw;
		System.out.println("after withdraw balance is="+balance);
	}
}
public void display()
{
	System.out.println("account no="+accNumber);
	System.out.println("account holder name="+name);
	System.out.println("balance="+balance);
}
}

class bankManagement{
	public static void main(String args[])
	{
		BankAccount obj[]=new BankAccount[100];
		for(int i=0;i<obj.length;i++)
		{
		obj[i]=new BankAccount();
		obj[i].getInfo();
		obj[i].deposit();
		obj[i].withdraw();
		obj[i].display();
        }
	}
}
		
	