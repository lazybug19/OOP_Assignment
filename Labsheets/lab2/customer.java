import java.util.Scanner;

public class customer {
  private String name;
  private int time;
  private double interestRate;
  private double principalAmount;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    if (time > 0)
      this.time = time;
    else {
      System.out.println("Invalid output");
      System.exit(0);
    }
  }

  public double getIR() {
    return interestRate;
  }

  public void setIR(double interestRate) {
    if (interestRate > 0)
      this.interestRate = interestRate;
    else {
      System.out.println("Invalid output");
      System.exit(0);
    }
  }

  public double getPA() {
    return principalAmount;
  }

  public void setPA(double principalAmount) {
    if (principalAmount > 0)
      this.principalAmount = principalAmount;
    else {
      System.out.println("Invalid output");
      System.exit(0);
    }
  }

  public void calculateFinalAmount() {
    double FinalAmount;
    FinalAmount = principalAmount * (1 + (time * interestRate / 100));
    System.out.println("Customer Details:");
    System.out.println("Name: " + name);
    System.out.println("Loan Period: " + time);
    System.out.println("Annual Interest Rate: " + interestRate);
    System.out.println("Principal Amoutn: " + principalAmount);
    System.out.print("Final Amount to be Repaid: Rs." + FinalAmount);
  }

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    customer person = new customer();

    System.out.print("Enter customer name: ");
    String name = sc.nextLine();
    person.setName(name);

    System.out.print("Enter loan period (in years): ");
    int time = sc.nextInt();
    person.setTime(time);

    System.out.print("Enter annual interest rate (%): ");
    double interestRate = sc.nextDouble();
    person.setIR(interestRate);

    System.out.print("Enter principal amount: ");
    double principalAmount = sc.nextDouble();
    person.setPA(principalAmount);

    person.calculateFinalAmount();
  }
}
