package streamTest;

public  class Developer{
	
	private String name;
	private String title;

	public Developer(String n, String c){
		this.name = n;
		this.title = c;
	}

	public String getName(){
		return this.name;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String newTitle){
		this.title = newTitle;
	}

	public String toString(){
		return "Developer:"+this.name + " , " + this.title;
	}
}
