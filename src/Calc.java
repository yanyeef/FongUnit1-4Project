
public class Calc {
    private double first;
    private double second;
    private String expression;
    private double radian;

    //constructor class
    public Calc(double one, double two) {
        this.first = one;
        this.second = two;
    }

    public Calc(double one){
        this.first = one;

    }

    public Calc(String expression){
        this.expression = expression;
    }

    public double add(){
        return first + second;
    }

    public double subtract() {
        return first -second;
    }

    public double multiply() {
        return first* second;
    }

    public double divide() {
        return (double) first/ second;
    }

    public void radian() {
        this.radian =Math.toRadians(first);
    }

    public double sin() {
        return Math.sin(radian);
    }

    public double cos() {
        return Math.cos(radian);
    }

    public double tan() {
        return Math.tan(radian);
    }

    public double sqrt() {
        return Math.sqrt(first);
    }

    public double pow() {
        return Math.pow(first, second);
    }




}
