
public class Process {

    static Bank bank1 = new Bank("Privat");
    static Bank bank2 = new Bank("Oshchad");

    static User user1 = new User("Andrew");
    static User user2 = new User("Mykola");

    static BankAccount account1 = new BankAccount("111",
            "UAH", 200);
    static BankAccount account2 = new BankAccount("222",
            "UAH", 100);
    static BankAccount account3 = new BankAccount("333", "USD", 10);

    static BankAccount account4 = new BankAccount("444", "USD", 10);


    public static void main(String[] args) throws Exception {
        user1.addAccount(account1);
        user1.addAccount(account3);
        user1.addAccount(account4);

        user2.addAccount(account2);
        //user2.addAccount(account3); this will crash the program

        bank1.addAccount(account1);
        bank2.addAccount(account2);
        //bank1.addAccount(account1);

        bank1.transfer(account1, bank2, account2, 100, user1, user2); //6%
        System.out.println("Andrew's UAH balance: " + account1.getBalance());
        System.out.println("Mykola's UAH balance: " + account2.getBalance());

        System.out.println("--------------------------------");

        bank1.transfer(account1, bank2, account2, 100, user1, user1); //2% 194 + 98 = 292
        System.out.println("Andrew's UAH balance: " + account1.getBalance());
        System.out.println("Mykola's UAH balance: " + account2.getBalance());

        System.out.println("--------------------------------");

        bank1.transfer(account3, bank1, account4, 1, user1, user1); //0%
        System.out.println("Andrew's USD balance (account3): " + account3.getBalance());
        System.out.println("Andrew's USD balance (account4): " + account4.getBalance());
    }

}