
/**
 * The Calc class represents a Calculator with values and math sign
 */
public class Calc {
    /** This is the first value */
    private double first;
    /** This is the second value */
    private double second;
    /** This is the expression*/
    private String expression;
    /** This is the math sign  */
    private String sign;
    /** This is the radian value*/
    private double radian;
    private int numOfValues;

    /** Two parameter constructor initializes coordinates to
     @param one - first value
     @param sign - math sign
     */
    public Calc(double one, String sign){
        this.first = one;
        this.sign = sign;
    }

    /** Default constructor return 0 */
    public Calc(){
        this.first =0;
        this.sign = "+";
        this.second = 0;
    }

    /** Two parameter constructor initializes coordinates to
     * @param expression - math expression
     * @param sign - math sign
     */
    public Calc(String expression, String sign){
        this.expression = expression;
        this.sign = sign;
    }
    /** void method that returns zero */
    public void zero(){
        int zero = 0;
        System.out.println("=" + zero);
    }

    /** initializes radian and returns radian value
     * @param first - first value inputted
     * @return double - the radian
     */
    public double radian(double first) {
        this.radian =Math.toRadians(first);
        return radian;
    }

    /** returns the sin
     * @param radian - radian value
     * @return double - the sin value with input of radian
     */
    public double sin(double radian) {
        return Math.sin(radian);
    }

    /** return the cos value
     * @param radian- radian value
     * @return double - the cos value
     */
    public double cos(double radian) {
        return Math.cos(radian);
    }

    /** return the tan value
     * @param radian - radian value
     * @return double - the tan value
     */
    public double tan(double radian) {
        return Math.tan(radian);
    }

    /** return the sqrt value
     * @return double sqrt
     */
    public double sqrt() {
        return Math.sqrt(first);
    }

    /** get the power of value
     * @return double power of
     */
    public double pow() {
        return Math.pow(first, second);
    }

    /** chooses which method to use sqrt, sin, cos, tan
     * @return double result
     */
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

    /** chooses which method to use add, subtract, mutiply, divide
     * @param numOfValues
     * @param sign
     * @return double result
     */
    public double twoVal(int numOfValues, String sign) {
        double result = 0;
        if (sign.equals("+ ")) {
            result = expressionAdd(numOfValues, sign);
        } else if (sign.equals("- ")) {
            result = sub(numOfValues, sign);
        } else if (sign.equals("* ")) {
            result = mult(numOfValues, sign);
        } else if (sign.equals("/ ")) {
            result = div(numOfValues,sign);
        } else if (sign.equals("^ ")) {
            result = pow();
        }
        return result;
    }

    /** get the expression
     * @return String entire expression and result from oneVal()
     */
    public String toString1() {
        if(!sign.equals("!")) {
            return sign + " " + first + " = " + "\n" + oneVal();
        } else {
            return printFactoral();
        }
    }

    /** get the expression if user inputs multiple values
     * @param numOfValues - total number of values inputted
     * @return String of entire expression and
     */
    public String toString2(int numOfValues){
        String current = expression;
        String end = "";
        while (numOfValues > 0) {
            double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
            if (current.length() > 3 && current.contains(sign)) {
                current = current.substring(current.indexOf(" ") + 3);
            }
            end += value + " " + sign ;
            numOfValues--;
        }
        end = end.substring(0, end.length() -2) + "= ";
        return end;
    }

    /** solves for factorial
     * @return int of factorial
     */
    public String factorial(){
        double result = 1;
        String end ="";
        while( first >1) {
            result = result * first;
            first--;
        }
        end = result + "";
        if(first <0){
            end = "Error";
        }
        return  end;
    }

    /** prints factorial
     * @return String with factorial and expression
     */
    public String printFactoral() {
        return (int)first + sign  + " = " + "\n" + factorial();
    }

    /** solve using addition
     * @param numOfVal - number of values inputted
     * @param sign - math sign
     * @return double of sum
     */
    public double expressionAdd(int numOfVal, String sign){

        String current = expression.substring(0, expression.length()-1);
        double num =0;

        if(sign.equals("+ ")) {
            while (numOfVal > 0) {
                double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
                if (current.length() > 3 && current.contains("+ ")) {
                    current = current.substring(current.indexOf(" ") + 3);
                }
                num += value;
                numOfVal--;
            }
        }
        return num;
    }

    /** solve using subtraction
     * @param numOfVal - number of values inputted
     * @param sign - math sign
     * @return double of difference
     */
    public double sub(int numOfVal, String sign){
        String current = expression.substring(0, expression.length()-1);
        double num =Double.parseDouble(current.substring(0, current.indexOf(" ")));
        current = current.substring(current.indexOf(" ") + 3);

        if(sign.equals("- ")) {
            while (numOfVal > 1) {
                double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
                if (current.length() > 3 && current.contains("- ")) {
                    current = current.substring(current.indexOf(" ") + 3);
                }
                num -= value;
                numOfVal--;
            }
        }
        return num;
    }
    /** solve using mutliplication
     * @param numOfVal - number of values inputted
     * @param sign - math sign
     * @return double of product
     */
    public double mult(int numOfVal, String sign){
        String current = expression.substring(0, expression.length()-1);
        double num =1;

        if(sign.equals("* ")) {
            while (numOfVal > 0) {
                double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
                if (current.length() > 3 && current.contains("* ")) {
                    current = current.substring(current.indexOf(" ") + 3);
                }
                num = num* value;
                numOfVal--;
            }
        }
        return num;
    }

    /** solve using division
     * @param numOfVal - number of values inputted
     * @param sign - math sign
     * @return double of quotient
     */
    public double div(int numOfVal, String sign){
        String current = expression.substring(0, expression.length()-1);
        double num =Double.parseDouble(current.substring(0, current.indexOf(" ")));
        current = current.substring(current.indexOf(" ") + 3);

        if(sign.equals("/ ")) {
            while (numOfVal > 1) {
                double value = Double.parseDouble(current.substring(0, current.indexOf(" ")));
                if (current.length() > 3 && current.contains("/ ")) {
                    current = current.substring(current.indexOf(" ") + 3);
                }
                num /= value;
                numOfVal--;
            }
        }
        return num;
    }




}
