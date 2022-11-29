import java.util.Scanner;
public class CalcRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Type in the first value: ");
        String one = scan.nextLine();
        System.out.println("how much values are there: ");
        int total = scan.nextInt();

        if(total >2){
            Calc first = new Calc(one);
            first.add();
        }
    }
}
