package edu.umb.cs.cs680.hw11;

import java.util.Comparator;

public class ElementKindComparator implements Comparator<FSElement> 
{
	@Override
	public int compare(FSElement f1, FSElement f2) 
	{
		return f1.getType().compareTo(f2.getType());
	}
	
}

