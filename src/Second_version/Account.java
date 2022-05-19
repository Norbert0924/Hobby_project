package Second_version;

import java.util.Scanner;

public abstract class Account {

    protected double balance;
    protected double transaction;
    protected String name;
    private final String id;
    protected double interest;

    public String getId() {
        return id;
    }

    public Account(String name, String id, double interest, double balance) {
        this.name = name;
        this.id = id;
        this.interest=interest;
        this.balance=balance;
    }
    public void deposit(double amount) {
        if(amount!=0){
            balance+=amount;
            transaction=amount;
        }
    }
    public void withdrawal(double amount) {
        if(amount!=0 && balance>=amount){
            balance-=amount;
            transaction=-amount;
        }
        else if(balance<amount){
            System.out.println("Not possible, your balance is not enough");
        }
    }
    public void getTransaction() {
        if(transaction>0){
            System.out.println("Deposited amount :"+transaction);
        } else if (transaction<0) {
            System.out.println("Witdrawn amount "+Math.abs(transaction));
        } else {
            System.out.println("Not a transaction");
        }
    }
    public void computeInterest(double years) {

        double a=balance*(1+interest/100);
        double b=years;
        double newBalance=Math.pow(a,b);
        System.out.println("The available interestRate recently "+(interest)+"%");
        System.out.println("Your available balance after: " +years+" year(s) is "+newBalance);
    }


    public void mainInformation(){
        char option;

        Scanner scanner=new Scanner(System.in);

        System.out.println("Welcome dear "+name);
        System.out.println("Your ID: "+id);

        System.out.println("\n");

        System.out.println("a) Balance");
        System.out.println("b) Deposit");
        System.out.println("c) Withdraw");
        System.out.println("d) Transaction check");
        System.out.println("e) Interest Rate");
        System.out.println("f) Exit");

        do{
            System.out.println("****************");
            System.out.println("Choose an option");

            option=scanner.next().charAt(0);
            System.out.println("\n");

            switch (option){

                case 'a':
                    System.out.println("......................");
                    System.out.println(" Current avaliable balance ="+balance);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case 'b':
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    double amount1=scanner.nextDouble();
                    deposit(amount1);
                    System.out.println("\n");
                    break;

                case 'c':
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amount2=scanner.nextDouble();
                    withdrawal(amount2);
                    System.out.println("\n");
                    break;

                case 'd':
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getTransaction();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("......................");
                    System.out.println("Interest period:");
                    double period=scanner.nextDouble();
                    computeInterest(period);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case 'f':
                    System.out.println("......................");
                    System.out.println("Thank you");
                    break;

                default:
                    System.out.println("Choose a correct option");
                    break;
            }
        }
        while(option!='f');
        System.out.println("Thank you for choosing us");
    }
}


