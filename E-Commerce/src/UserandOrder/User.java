package UserandOrder;

public class User {
	private int userId;
	private String username, password;
	private static int lastUsedId = 0;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.userId = lastUsedId++;
	}
	
	public int getUserId() {
		return userId;
	}
	


	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User\nUsername:" + username + "\nPassword:" + password + "\n";
	};
	
	
}
