package edu.umb.cs.cs680.hw11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;

public class CountingVisitorTest {

	FileSystem fs = FileSystem.getInstance();
	Directory root;
	CountingVisitor visitor;
	@Before
	public void setup() {
		root = new Directory(null, "root", "Raveena Mewani");
		fs.setRoot(root);
		File a = new File(root, "a", "Raveena Mewani", 10);
		File b = new File(root, "b","Raveena Mewani", 10);
		File c = new File(root, "c","Raveena Mewani",20);
		Link x = new Link(root, "x", "Raveena Mewani",a);
		
		fs.setRoot(root);
		root.appendChild(0,a);
		root.appendChild(1,b);
		root.appendChild(2,c);		
		root.appendChild(3,x);
		visitor = new CountingVisitor();
		root.accept(visitor);
		
	}
	@Test
	public void getDirNumZero() {
		
		int expected = 1;
		int actual = visitor.getDirNum();
		assertThat(actual, is(expected));
		System.out.println("Refer Test Cases");
		System.out.println("Directory: " + visitor.getDirNum());
		
       
	}
	@Test
	public void getFileNum() {		
		int expected = 3;
		int actual = visitor.getFileNum();
		assertThat(actual, is(expected));
		System.out.println("Refer Test Cases");
		 System.out.println("File: " + visitor.getFileNum());
	     
	}
	@Test
	public void getLinkNum() {
		int expected = 1;
		int actual = visitor.getLinkNum();
		assertThat(actual, is(expected));
		System.out.println("Refer Test Cases");
		   System.out.println("Link: " + visitor.getLinkNum());
	}

}
