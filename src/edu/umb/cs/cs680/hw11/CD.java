package edu.umb.cs.cs680.hw11;


public class CD implements Command { 

	private FileSystem fs = FileSystem.getInstance();
	private FSElement current;
	private String s;
	public CD(String s) {	
		this.s = s;
	}

	public CD() {		
		this.current = fs.getRoot();
	}

	@Override
	public void execute() {
		
			if(null != this.s && !this.s.isEmpty()) {				
				current =  fs.getElementFromfullPath(s);
			}
			
			if (current != null)
			{
				if(current  instanceof Directory)
				{
					Directory d = (Directory) current;
					fs.setCurrentDirectory(d);
				}
				else 
				{
					fs.setCurrentDirectory(current.getParent());
				}			
			}
			else
			{
				System.out.println("no such dir exists");
			}
	
			return;
	}	
}
