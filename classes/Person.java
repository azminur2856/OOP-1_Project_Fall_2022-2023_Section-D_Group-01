package classes;
import java.lang.*;
import interfaces.*;
public abstract class Person implements IPerson
{
	private String name;
	private String age;
	
	public Person (String name, String age)
	{
		this.name = name;
		this.age=age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAge()
	{
		return age;
	}
}
