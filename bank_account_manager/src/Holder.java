public class Holder {

    private String name;
    private long id;
    private double amount;

    public Holder (String name, long id) {
        this.name = name;
        this.id = id;
        this.amount = 0.0;
    }

    public String getName () {
        return name;
    }

    public long getId () {
        return id;
    }

    public double getAmount () {
        return amount;
    }
    public void setAmount (double newAmount) {
        amount = newAmount;
    }

    public void depositMoney (double amountToDeposit) {
        amount += amountToDeposit;
        System.out.printf("✅ Deposit of £%.1f completed successfully!\n", amountToDeposit);
    }

    public void withdrawMoney (double amountToWithdraw) {
        if (amount < amountToWithdraw) {
            System.out.println("❌ Your balance is insufficient.");
            System.out.printf("you just have £%.1f\n", amount);
        } else {
            amount -= amountToWithdraw;
            System.out.printf("✅ Withdrawal of £%.1f completed successfully!\n", amountToWithdraw);
        }
    }

    public void accountBalance () {
        System.out.printf("💰 Current balance: £%.1f\n", amount);
    }

    public void accountInformation () {
        System.out.println("\n🧾 Account details:");
        System.out.println("- ID: " + id);
        System.out.println("- Owner: " + name);
        System.out.printf("- Balance: £%.1f\n", amount);
    }

}
