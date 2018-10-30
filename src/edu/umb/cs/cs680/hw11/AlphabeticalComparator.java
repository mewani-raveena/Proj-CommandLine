package edu.umb.cs.cs680.hw11;
import java.util.Comparator;

//import hw11.fileSystem.FSElement;

public class AlphabeticalComparator implements Comparator<FSElement> 
{
	@Override
	public int compare(FSElement f1, FSElement f2) 
	{
		return f1.getName().compareTo(f2.getName());
	}
	
}
