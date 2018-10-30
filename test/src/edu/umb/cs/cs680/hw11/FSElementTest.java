package edu.umb.cs.cs680.hw11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class FSElementTest {

	private Directory home;
	private File file = new File(home, "F1", "Raveena",20);
	

	@Test
	public void GetnSetName()
	{	
		file.setName("File");
		String actual = "File";
		String expected = file.getName();
		assertThat(actual, is(expected));
	}

	@Test
	public void GetnSetOwner()
	{
		file.setOwner("Raveena Mewani");
		String actual = "Raveena Mewani";
		String expected = file.getOwner();
		assertThat(actual, is(expected));
	}


	@Test
	public void  GetnSetSize()
	{
		
		int expected = 20;
		int actual = file.getSize();
		assertThat(actual,is(expected));
		file.setSize(30);
		assertThat(file.getSize(),is(30));
	}

	@Test
	public void  GetnSetparent()
	{
		
		Directory newParent = new Directory(null,"newParent","Raveena");
		file.setParent(newParent);
		assertThat(file.getParent(),is(sameInstance(newParent)));
		
	}
}
