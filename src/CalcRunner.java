import java.util.Scanner;
public class CalcRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = "";
        System.out.print("Type in a value or sign: ");
        String input = scan.nextLine();
        expression+= input + " ";
        while(!(input.equals("="))){
            System.out.print("Type in a value or sign: ");
            input = scan.nextLine();
            expression+= input + " ";
        }

        if(input.equals("=")) {
            double result = 0;

            String firstValue = expression.substring(0, expression.indexOf(" "));
            double fV = Double.parseDouble(firstValue);
            String secValue = expression.substring(expression.indexOf(" ") + 3, expression.indexOf("=") - 1);
            double sV = Double.parseDouble(secValue);
            String sign = expression.substring(expression.indexOf(" ") + 1, expression.indexOf(" ") + 2);

            Calc twoNumbers = new Calc(fV, sV);
            if (sign.equals("+")) {
                result = twoNumbers.add();
                System.out.println(expression + result);
            } else if (sign.equals("-")) {
                result = twoNumbers.subtract();
                System.out.println(expression + result);
            } else if (sign.equals("*")) {
                result = twoNumbers.multiply();
                System.out.println(expression + result);
            } else if (sign.equals("/")) {
                result = twoNumbers.divide();
                System.out.println(expression + result);
            } else if (sign.equals("^")) {
                result = twoNumbers.pow();
                System.out.println(expression + result);
            }
        }

    }
}
