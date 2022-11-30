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
            System.out.println(expression);
            System.out.println("How much values did you input: ");
            int numOfValues = scan.nextInt();
            double result = 0;

            if(numOfValues==1){
                String single = expression.substring(expression.indexOf(" ") +1, expression.indexOf("=") - 1);
                double s = Double.parseDouble(single);
                String math = expression.substring(0, expression.indexOf(" "));

                Calc oneValue = new Calc(s);
                if(math.equals("sqrt")){
                    result = oneValue.sqrt();
                    System.out.println(expression + result);
                } else if (math.equals("sin")){
                    result = oneValue.sin(oneValue.radian(s));
                    System.out.println(expression + result);
                } else if (math.equals("cos")){
                    result = oneValue.cos(oneValue.radian(s));
                    System.out.println(expression + result);
                } else if( math.equals("tan")){
                    result = oneValue.tan(oneValue.radian(s));
                    System.out.println(expression + result);
                }
            }
            else if(numOfValues ==2) {

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
}
