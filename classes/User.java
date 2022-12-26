package classes;
import java.lang.*;
import interfaces.*;
public class User extends Person implements IUser
{
	private String password;
	
	public User(String name, String age, String password)
	{
		super(name,age);
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
}