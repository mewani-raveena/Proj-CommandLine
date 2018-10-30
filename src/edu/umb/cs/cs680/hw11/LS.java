package edu.umb.cs.cs680.hw11;

import java.util.LinkedList;
public class LS implements Command{
private FileSystem f;
	
	public LS()
	{
		f = FileSystem.getInstance();
	}
	
	@Override
	public void execute() 
	{	
		Directory current = f.getCurrentDirectory();
		LinkedList<FSElement> children = current.getChildren();
		System.out.println("\n");
		System.out.println("Name"+"   "+"Type");
		for(int i=0; i<children.size();i++)
		{
			System.out.println(children.get(i).getName()+",    "+children.get(i).getType());
		}
		System.out.println("\n");
		return ;
	}

}
