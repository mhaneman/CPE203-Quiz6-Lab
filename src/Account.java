import java.util.*;

public final class Account implements Comparable<Account> {

    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balance;
    private boolean isNewAccount;


    public Account(String firstName, String lastName, int accountNumber, double balance, boolean isNewAccount) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.isNewAccount = isNewAccount;

    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber &&
                Double.compare(account.balance, balance) == 0 &&
                isNewAccount == account.isNewAccount &&
                Objects.equals(firstName, account.firstName) &&
                Objects.equals(lastName, account.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, accountNumber, balance, isNewAccount);
    }

    /**
     * TO DO:
     * Write compareTo (natural ordering of class):
     * 1. accountNumber in ascending order
     *      If same, break ties:
     * 2. old Accounts before new accounts
     *      If same, break ties
     * 3. LastName
     *      If same, break ties
     * 4. FirstName
     *      If same, break ties
     * 5. Lower Balance before higher balance
     */
    @Override
    public int compareTo(Account other) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this.accountNumber - other.accountNumber != 0)
            return (this.accountNumber - other.accountNumber > 0) ? AFTER : BEFORE;

        if (((this.isNewAccount) ? 1 : 0) - ((other.isNewAccount) ? 1 : 0) != 0)
            return ((this.isNewAccount) ? 1 : 0) - ((other.isNewAccount) ? 1 : 0);

        if (this.lastName.compareTo(other.firstName) != 0)
            return this.lastName.compareTo(other.firstName);

        if (this.firstName.compareTo(other.firstName) != 0)
            return this.firstName.compareTo(other.firstName);

        if (this.balance - other.balance == 0)
            return EQUAL;
        return (this.balance - other.balance < 0) ? AFTER : BEFORE;
    }
}
