
import java.util.ArrayList;
import java.util.List;

public class Accounts {
    static public List<BankAccount> allAccounts = new ArrayList<>();

    static public void add(BankAccount bankAccount) {
        allAccounts.add(bankAccount);
    }

    static public boolean isAccountInList(BankAccount bankAccount) {
        for (int i =0; i < allAccounts.size(); i++) {
            if ((allAccounts.get(i)).getAccountNumber() == bankAccount.getAccountNumber()) {
                return true;
            }
        }
        return false;
    }

}
