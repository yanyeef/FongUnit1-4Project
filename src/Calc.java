
/**
 * The Calc class represents a Calculator with values and math sign
 */
public class Calc {
    private double first;
    private double second;
    private String expression;
    private String sign;
    private double radian;
    private int numOfValues;

    //constructor class
    public Calc(double one, String sign){
        this.first = one;
        this.sign = sign;
    }
// if user just types = it will return 0


    public Calc(){
        this.first =0;
        this.sign = "+";
        this.second = 0;
    }

    public Calc(String expression, String sign){
        this.expression = expression;
        this.sign = sign;
    }
    public void zero(){
        int zero = 0;
        System.out.println("=" + zero);
    }





    public double radian(double first) {
        this.radian =Math.toRadians(first);
        return radian;
    }

    public double sin(double radian) {
        return Math.sin(radian);
    }

    public double cos(double radian) {
        return Math.cos(radian);
    }

    public double tan(double radian) {
        return Math.tan(radian);
    }

    public double sqrt() {
        return Math.sqrt(first);
    }

    public double pow() {
        return Math.pow(first, second);
    }

    public double oneVal() {
        double result =0;
        if (sign.equals("sqrt")){
            result = sqrt();
        } else if (sign.equals("sin")){
            result = sin(radian(first));
        } else if (sign.equals("cos")){
            result = cos(radian(first));
        } else if(sign.equals("tan")){
            result = tan(radian(first));
        }
        return result;
    }

    public double twoVal(int numOfValues, String sign) {
        double result = 0;
        if (sign.equals("+")) {
            result = expressionAdd(numOfValues, sign);
        } else if (sign.equals("-")) {
            result = sub(numOfValues, sign);
        } else if (sign.equals("*")) {
            result = mult(numOfValues, sign);
        } else if (sign.equals("/")) {
            result = div(numOfValues,sign);
        } else if (sign.equals("^")) {
            result = pow();
        }
        return result;
    }

    public String toString1() {
        if(!sign.equals("!")) {
            return sign + " " + first + " = " + "\n" + oneVal();
        } else {
            return printFactoral();
        }
    }

    public String toString2(int numOfValues){
        String current = expression;
        String end = "";
        while (numOfValues > 0) {
            double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
            if (current.length() > 3 && current.contains(sign)) {
                current = current.substring(current.indexOf(" ") + 3);
            }
            end += value + " " + sign;
            numOfValues--;
        }
        return end;
    }

    public int factoral(){
        double result = 1;
        while( first >1) {
            result = result * first;
            first--;
        }
        return (int)result;
    }

    public String printFactoral() {
        return (int)first + sign  + " = " + "\n" + factoral();
    }

    public double expressionAdd(int numOfVal, String sign){

        String current = expression.substring(0, expression.length()-1);
        double num =0;

        if(sign.equals("+")) {
            while (numOfVal > 0) {
                double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
                if (current.length() > 3 && current.contains("+")) {
                    current = current.substring(current.indexOf(" ") + 3);
                }
                num += value;
                numOfVal--;
            }
        }
        return num;
    }

    public double sub(int numOfVal, String sign){
        String current = expression.substring(0, expression.length()-1);
        double num =Double.parseDouble(current.substring(0, current.indexOf(" ")));
        current = current.substring(current.indexOf(" ") + 3);

        if(sign.equals("-")) {
            while (numOfVal > 1) {
                double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
                if (current.length() > 3 && current.contains("-")) {
                    current = current.substring(current.indexOf(" ") + 3);
                }
                num -= value;
                numOfVal--;
            }
        }
        return num;
    }

    public double mult(int numOfVal, String sign){
        String current = expression.substring(0, expression.length()-1);
        double num =1;

        if(sign.equals("*")) {
            while (numOfVal > 0) {
                double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
                if (current.length() > 3 && current.contains("*")) {
                    current = current.substring(current.indexOf(" ") + 3);
                }
                num = num* value;
                numOfVal--;
            }
        }
        return num;
    }

    public double div(int numOfVal, String sign){
        String current = expression.substring(0, expression.length()-1);
        double num =Double.parseDouble(current.substring(0, current.indexOf(" ")));
        current = current.substring(current.indexOf(" ") + 3);

        if(sign.equals("/")) {
            while (numOfVal > 1) {
                double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
                if (current.length() > 3 && current.contains("/")) {
                    current = current.substring(current.indexOf(" ") + 3);
                }
                num /= value;
                numOfVal--;
            }
        }
        return num;
    }




}
