import java.util.ArrayList;
import java.util.List;


public class User {
    private final String name;
    private final List<BankAccount> accounts = new ArrayList<>();

    public User(String name) {
        this.name = name;

    }

    public void addAccount(BankAccount account) {
        if (Bank.accounts.containsValue(account) || Accounts.isAccountInList(account)) {
            throw new IllegalArgumentException("Account already exists");
        }
        accounts.add(account);
        Accounts.allAccounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}













/*
public class User {
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public String getSecond_name() {
        return second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
    private String first_name;
    private String second_name;
    private boolean isLoggedIn;
    ArrayList<BankAccount> accounts;

    public User(String first_name, String second_name, ArrayList<BankAccount> accounts, boolean isLoggedIn) {
        this.second_name = second_name;
        this.accounts = accounts;
        this.first_name = first_name;
        this.isLoggedIn = isLoggedIn;
        users.add(this);
    }

    @Override
    public String toString() {
        if (isLoggedIn) {
            return first_name + " " + second_name + " is logged in" + ", " + accounts.toString();
        } else {
            return first_name + " " + second_name + " isn't logged in" + ", " + accounts.toString();
        }
    }
    public static void addUser()
    {
         Scanner scanner = new Scanner(System.in);

        //scanner doesn't work properly if to pass as an argument
        System.out.println("Please enter your first name: ");
        String first_name = scanner.nextLine();
        System.out.println("Please enter your second name: ");
        String second_name = scanner.nextLine();
        //ASK: Is it better to create method in BankAccount class to init it?
        System.out.println("Please enter the currency: ");
        String currency= scanner.nextLine();
        System.out.println("Please enter the account number: ");
        int account_number= scanner.nextInt();
        System.out.println("Please enter the bank id: ");

        int bank_id = scanner.nextInt();

        Bank bank = new Bank(bank_id);

        BankAccount bankAccount = new BankAccount(bank, currency, account_number);

        //new User(first_name, second_name, bankAccount, true);
    }
    public static void logIn(Scanner scanner)
    {
        System.out.println("Please enter your first name: ");
        String first_name = scanner.nextLine();
        System.out.println("Please enter your second name: ");
        String second_name = scanner.nextLine();
        findByName(first_name, second_name).isLoggedIn = true;
    }
    public static void logOut()
    {
        if (findLoggedInUser() == null)
            return;
        findLoggedInUser().isLoggedIn = false;
    }




    public static User findLoggedInUser() {
        for (User user : users) {
            if(user.isLoggedIn() == true)
            {
                return user;
            }
        }
        return null;
    }
    public static User findByName(String first_name, String second_name) {
        for (User user : users) {
            if(user.getFirst_name() == first_name &&user.getSecond_name() == second_name)
            {
                return user;
            }
        }
        return null;
    }
    public void printInfo()
    {
        System.out.println(this.toString());

    }
}
*/