package bg.swift.HW06;

public class Bank {
	private static Account[] accounts = new Account[5];
	private static int numberOfAccounts = 0;
	private static int indexOfAccount = 0;
	private static double assets = 0;
	
	private static boolean isValidAmount(double amount) {
		if (amount > 0) {
			return true;
		}
		return false;
	}

	public static void openAccount(String name, String govld, String username, String password) {
		if (numberOfAccounts <= 4) {
			Account acc = new Account(name, govld, username, password);
			accounts[numberOfAccounts] = acc;
			numberOfAccounts++;
			System.out.println("OPEN success");
			return;
		}
		System.out.println("OPEN fail");
	}

	private static Account getAccount(String username) {		
		for (int i = 0; i < numberOfAccounts; i++) {
			if(accounts[i].getUserName() != null && accounts[i].getUserName().equals(username)) {
				indexOfAccount = i;
				return accounts[i];
			}
		}
		return null;
	}

	private static boolean checkUserAccess(Account acc, String password) {
		if (acc != null && acc.hasAccess(password)) {
			return true;
		}
		return false;
	}
	
	public static void closeAccount(String username, String password) {
		if (checkUserAccess(getAccount(username), password)) {
			accounts[indexOfAccount] = null;
			if (indexOfAccount < numberOfAccounts - 1) {
				for (int i = indexOfAccount; i < numberOfAccounts - 1; i++) {
					accounts[i] = accounts[i + 1];
				}
				numberOfAccounts--;
			} else {
				numberOfAccounts--;
			}
			System.out.println("CLOSE success");
			return;
		}
		System.out.println("CLOSE fail");
	}

	public static void deposit(String username, double amount) {
		if(getAccount(username) != null && isValidAmount(amount)) {
			getAccount(username).deposit(amount);
			System.out.println("DEPOSIT success");
			return;
		}
		System.out.println("DEPOSIT fail");
	}

	public static void withdraw(String username, String password, double amount) {
		Account acc = getAccount(username);
		if (checkUserAccess(acc, password) && isValidAmount(amount)) {
			acc.withdraw(amount);
		}
	}

	public static void transfer(String username, String password, double amount, String recipient) {
		Account acc = getAccount(username);
		Account acc1 = getAccount(recipient);
		
		if(checkUserAccess(acc, password) && 
			isValidAmount(amount)) {
			acc.setBalance(acc.getBalance() - amount);
			acc1.deposit(amount);
			System.out.println("TRANSFER success");
			return;
		}
		System.out.println("TRANSFER fail");
	}

	public static double getAssets() {
		for (int i = 0; i < numberOfAccounts; i++) {
			assets += accounts[i].getBalance();
		}
		return assets;
	}

	public static void printInfoAccounts() {
		for (int i = 0; i < numberOfAccounts; i++) {
			System.out.printf("%s, %s, %.2f%n", 
					accounts[i].getName(), 
					accounts[i].getGovId(),
					accounts[i].getBalance());
		}
	}











}
