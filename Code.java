

import java.io.*;
import java.util.*;

class Account{
 
    private String accNo;
    private String accHolder;
    private long balance;
    

    public Account(String accNo, String accHolder){
        this.accNo = accNo;
        this.accHolder = accHolder;
        this.balance = 0;
    }
    
  
    public String getAccNo(){
        return this.accNo;
    }
    
    public String getAccHolder(){
        return this.accHolder;
    }
    
    public long showBalance(){
        return this.balance;
    }
    
   
    public void setAccNo(String accNo){
        this.accNo = accNo;
    }
    
    public void setAccHolder(String accHolder){
        this.accHolder = accHolder;
    }
    
    public void depositMoney(long money){
        this.balance += money;
    }
    
    public void withdrawMoney(long money){
        if(money <= this.balance){
            this.balance -= money;
        } else {
            System.out.println("Insufficient Balance"); 
        }
     }
     
 }
 
public class Main
{
    public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    HashMap<String ,Account> database=new  HashMap<>();
    
    while(true){
          String option = scan.next();
            
            if(option.equals("CREATE")){
                String accNo = scan.next();
                String accHolder = scan.next();
                
                
                Account acc = new Account(accNo, accHolder);
               
                database.put(accNo, acc);
                
            } else if(option.equals("DEPOSIT")){
                String accNo = scan.next();
                long money = scan.nextLong();
                
              
                Account acc = database.get(accNo);
               
                acc.depositMoney(money);
                
            } else if(option.equals("WITHDRAW")){
                String accNo = scan.next();
                long money = scan.nextLong();
                
              
                Account acc = database.get(accNo);
              
                acc.withdrawMoney(money);
                
            } else if(option.equals("BALANCE")){
                String accNo = scan.next();
                
               
                Account acc = database.get(accNo);
                System.out.print(acc.getAccHolder() + " ");
                System.out.println(acc.showBalance());
                
            } else {
                break;
            }
        
          }
    
    }
}