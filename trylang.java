import java.util.*;
public class trylang{
public static void main (String args[]){
    Scanner sc = new Scanner(System.in);

    String a;

        do{

        String operatorSwitch=null;
        int b=0;
        int c=0;

        Random number = new Random();
        int d = number.nextInt(100) +1;
        int e = number.nextInt(100) +1;

        Random operatorChoice = new Random();
        int operator = operatorChoice.nextInt(4);

        switch (operator){

            case 0: operatorSwitch= "+";
                c = d+e;
                break;
            case 1: operatorSwitch= "-";
                c = d-e;
                break;
            case 2: operatorSwitch= "*";
                c = d*e;
                break;
            case 3: operatorSwitch= "/";
                c = d/e;
                break;
            default: operatorSwitch= "";
        }
        System.out.println("What is: "+d+operatorSwitch+e+"?");
        b = sc.nextInt();


        if(b!=c)
            System.out.println("Wrong answer! Right answer is: "+c);
        else{if(b==c)
            System.out.println("Right answer!"+c);
        }
            System.out.println("Continue? y/n");
            a = sc.next();

        }while(a.equals("y"));
    }
}