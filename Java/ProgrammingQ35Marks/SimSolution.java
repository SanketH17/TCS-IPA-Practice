import java.util.Scanner;

public class SimSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Sim[] cards = new Sim[5];

        for (int i = 0; i < cards.length; i++) {
            int simId = sc.nextInt();sc.nextLine();
            String customerName = sc.nextLine();
            double balance = sc.nextDouble();
            double ratePerSecond = sc.nextDouble();
            String circle = sc.nextLine();

            cards[i] = new Sim(simId, customerName, balance, ratePerSecond, circle);
        }

        String circle1 = sc.nextLine();
        String circle2 = sc.nextLine();

        sc.close();

        Sim[] result = transferCustomerCircle(cards, circle1, circle2);

        for(Sim s : result) {
            System.out.println(s.getSimId() + " " + s.getCustomerName() + " " + s.getCircle() + " " + s.getRatePerSecond());
        }

    }

    /*
     * transferCustomerCircle - will transfer the customer to new circle(circle2)
     * where the circle attribute would match second parameter(circle1)
     * Method will return array of sim objects for which circle is transferred.
     * return array should be sorted in descending order of ratePerSecond
     */
    public static Sim[] transferCustomerCircle(Sim[] cards, String circle1, String circle2) {
        int count = 0;
        for (Sim s : cards) {
            if (s.getCircle().equals(circle1)) {
                count++;
            }
        }
        
        Sim[] result = new Sim[count];
        int index = 0;

        for(Sim s : cards) {
            if(s.getCircle().equals(circle1)) {
                s.setCircle(circle2);
                result[index] = s;
                index++;
            }
        }

        // sort array in descending order
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < i; j++) {
                if(result[i].getRatePerSecond() > result[j].getRatePerSecond()) {
                    Sim temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result;

    }

}

class Sim {
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    // getters and setters

    // simId
    public int getSimId() {
        return this.simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    // customerName
    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // balance
    public double getbalance() {
        return this.balance;
    }

    public void setbalance(double balance) {
        this.balance = balance;
    }

    // RatePerSecond
    public double getRatePerSecond() {
        return this.ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    // Circle
    public String getCircle() {
        return this.circle;
    }

    public void setCircle(String Circle) {
        this.circle = Circle;
    }

    // Constructors
    public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

}