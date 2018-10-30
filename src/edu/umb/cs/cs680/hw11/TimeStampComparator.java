package edu.umb.cs.cs680.hw11;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {

	@Override
	public int compare(FSElement f1, FSElement f2)
	{	
		
		return f1.getLastModified().compareTo(f2.getLastModified());
	}

}