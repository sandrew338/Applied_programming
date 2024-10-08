import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final String name;
    public static final Map<String, BankAccount> accounts = new HashMap<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addAccount(BankAccount account) {
        if (accounts.containsValue(account)) {
            throw new IllegalArgumentException("Account already exists");
        }
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void transfer(final BankAccount fromAccount, final Bank toBank,
                         final BankAccount toAccount, final double amount,
                         final User fromUser, final User toUser) throws Exception {
        final boolean isSameBank = this.name.equals(toBank.name);
        final boolean isSameUser = fromUser == toUser;

        double feePercentage = calculateFee(isSameBank, isSameUser);

        double convertedAmount = CurrencyConverter.convertCurrency(fromAccount.getCurrency(),
                toAccount.getCurrency(), amount);

        double totalAmountAfterFee = convertedAmount * (1 - feePercentage);

        fromAccount.withdraw(amount);

        toAccount.deposit(totalAmountAfterFee);
    }

    private double calculateFee(boolean isSameBank, boolean isSameUser) {
        if (isSameUser && isSameBank) {
            return 0.0;
        } else if (isSameUser) {
            return 0.02;
        } else if (isSameBank) {
            return 0.03;
        } else {
            return 0.06;
        }
    }
}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//
//            int input = 0;
//            do {
//                displayMenu();
//                System.out.println("Enter your choice: ");
//                input = scanner.nextInt();
//                organiseMenu(input, scanner);
//
//            } while (input != 8);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        scanner.close();
//    }
//    public static void organiseMenu(int input, Scanner scanner)
//    {
//        switch (input) {
//            case 1 -> User.addUser();
//            case 2 -> User.logIn(scanner);
//            case 3 ->User.logOut();
//            case 4 -> findLoggedInUser().printInfo();
//            default -> throw new RuntimeException();
//        }
//    }
//
//    //TODO: So in each class add init() for better perception
//    public static void displayMenu() {
//        System.out.println("""
//                '1' - add user
//                '2' - login
//                '3' - log out
//                '' - add bank account
//                '' - delete bank account
//                '' - delete user
//                '3' - print info
//                '' - print info about all users
//                '4' - transfer money in the same account in the same bank
//                '5' - transfer money in the same account in different banks
//                '6' - transfer money in different accounts in the same bank
//                '7' - transfer money in different accounts in different banks
//                \
//                '8' - exit""");
//    }


