import java.util.Scanner;

public class StudiKasus123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declaration of variables
        int priceperCup = 18000;
        int total_price;
        double change;
        double discount;
        double shortfall; // matches the "kurang" variable in the flowchart

        // Input data
        System.out.print("How many cups you want to buy: ");
        int totalcups = sc.nextInt();

        System.out.print("Input your payment: ");
        double payment = sc.nextDouble();

        double total_payment;

        // Calculation
        total_price = totalcups * priceperCup;
        discount = 0;

        // Selection using if-else to determine discount
        if (total_price >= 100000) {
            discount = total_price * 10 / 100;
        } else {
            discount = 0;
        }

        total_payment = total_price - discount;

        // Output data from calculation discount and total payment
        System.out.println("Total Price: " + total_price);
        System.out.println("Discount: " + discount);
        System.out.println("Total Payment: " + total_payment);

        // if-else selection to determine change or shortfall
        if (payment >= total_payment) {
            change = payment - total_payment;
            System.out.println("Change: " + change);
        } else {
            shortfall = total_payment - payment;
            System.out.println("Not enough money, shortfall Rp: " + shortfall);
        }

        sc.close();
    }
}
