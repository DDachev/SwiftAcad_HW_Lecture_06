package bg.swift.HW06;

public class Account {
	private String name;
	private String govld;
	private double balance = 0;
	private Credentials cr;

	public Account(String name, String govld, String username, String password) {
		if(isValidAll(name, govld)) {
			this.name = name;
			this.govld = govld;
			this.cr = Credentials.addNewUser(username, password);
		}

	}

	private boolean isValidAll(String name, String govld) {
		if(isValidName(name) && isValidGovld(govld)) {
			return true;
		}
		return false;
	}
	
	private boolean isValidName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isValidGovld(String govld) {		
		if (govld.length() == 10) {
			for (int i = 0; i < govld.length(); i++) {
				if (govld.charAt(i) < 48 || govld.charAt(i) > 57) {
					return false;
				}
			}
			return true;
		}
		return false;
	}	

	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (this.balance > amount) {
			this.balance -= amount;
			System.out.println("WITHDRAW success");
			return;
		}
		System.out.println("WITHDRAW fail");
	}

	public boolean hasAccess(String password) {
		if (Credentials.authentication(getUserName(), password)) {
			return true;
		}
		return false;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUserName() {
		return cr.getUserName();
	}

	public String getGovId() {
		return this.govld;
	}

	public String getName() {
		return this.name;
	}

	
	
	
	
}
