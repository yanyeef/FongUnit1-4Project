

import java.util.Scanner;


public class CalcRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String expression = "";
        System.out.println("If you want sin, cos, tan, !, or sqrt, type out the sign on the first line, then type out the value\ntype on to start");
        String on= scan.nextLine();
        while(!on.contains("no")) {
            System.out.print("");
            System.out.println("Type in a value or sign( off to end) : ");
            String input = scan.nextLine();
            expression += input + " ";
//            while (!(input.contains("="))) {
//                System.out.print("Type in a value or sign: ");
//                input = scan.nextLine();
//                expression += input + " ";
//            }

            if (input.contains("=")) {
                System.out.print("How much values did you input: ");
                int numOfValues = scan.nextInt();
                scan.nextLine(); // clearing the buffer

                if (numOfValues == 0) {
                    Calc noValue = new Calc();
                    noValue.zero();
                } else if (numOfValues == 1) {
                    String single = expression.substring(expression.indexOf(" ") + 1, expression.indexOf("=") - 1);
                    double s = Double.parseDouble(single);
                    String math = expression.substring(0, expression.indexOf(" "));
                    Calc oneValue = new Calc(s, math);
                    System.out.println(oneValue.toString1());

                } else {
                    String signEX = expression.substring(expression.indexOf(" ") + 1, expression.indexOf(" ") + 3);
                    Calc express = new Calc(expression, signEX);
                    System.out.println(express.toString2(numOfValues));
                    System.out.println(express.twoVal(numOfValues, signEX));
                }
            }
            else if(input.equals("off")) {
                on = "no";
                System.out.println();
            }
            expression = "";
        }
        if(on.contains("no")){
            System.out.println("----------------------------");
        }

    }

}