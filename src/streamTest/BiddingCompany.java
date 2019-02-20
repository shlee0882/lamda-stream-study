package streamTest;

public class BiddingCompany{

	private Developer developer;
	private String companyName;
	private int year;
	private int salary;

	public BiddingCompany(Developer developer, String companyName, int year, int salary)
	{
		this.developer = developer;
		this.companyName = companyName;
		this.year = year;
		this.salary = salary;
	}

	public Developer getDeveloper(){ 
		return this.developer;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public int getYear(){
		return this.year;
	}

	public int getSalary(){
		return this.salary;
	}
	
	public String toString(){
	    return "{" + this.developer + ", " +
	           "companyName: "+this.companyName+", " +
	           "year: "+this.year+", " +
	           "salary:" + this.salary +"}";
	}
}