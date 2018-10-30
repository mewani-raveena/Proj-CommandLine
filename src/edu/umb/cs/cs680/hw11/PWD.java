package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class PWD implements Command{
	private FileSystem f; 
	
	public PWD()
	{
		f = FileSystem.getInstance();
	}
	
	@Override
	public void execute() 
	{
		Directory cur = f.getCurrentDirectory();	
		
		ArrayList<String> path=new ArrayList<String>();		
		while(cur!=null){			
			path.add(cur.getName());
			cur=cur.getParent();
		}
		for(int i=path.size()-1;i>=0;i--){
			System.out.print("/"+path.get(i));
		}
		
	}
}
