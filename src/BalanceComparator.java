import java.util.Comparator;
/*
* TO DO:
*This class should compare all accounts by balance only (in ascending order)
 */

class BalanceComparator implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        if (o1.getBalance() - o2.getBalance() == 0)
            return 0;
        return (o1.getBalance() - o2.getBalance() > 0) ? 1 : -1;
    }
}


