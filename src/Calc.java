public class Calc {
    private double first;
    private double second;
    private String expression;

    //constructor class
    public Calc(double one, double two) {
        this.first = one;
        this.second = two;
    }

    public Calc(String expression){
        this.expression = expression;
    }

    public double add(){
        String current = expression;
        double sum = 0;
        if (current.length() != 0) {
            while ((current.substring(0, current.indexOf(" +") )).contains(" +") == false) {
                sum += Double.parseDouble(current.substring(0, current.indexOf(" +")));
                current = current.substring(current.indexOf("+") +1);
            }
        } else {
            return sum;
        }
        return first + second;


    }


}
