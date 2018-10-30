package edu.umb.cs.cs680.hw11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class SizeCountingVisitorTest {
	FileSystem fs = FileSystem.getInstance();
	Directory root;
	SizeCountingVisitor visitor;
	@Before
	public void setup() {
		root = new Directory(null, "root", "Raveena Mewani");
		fs.setRoot(root);
		File a = new File(root, "a", "Raveena Mewani", 10);
		File b = new File(root, "b","Raveena Mewani", 10);
		File c = new File(root, "c","Raveena Mewani",20);
		
		
		fs.setRoot(root);
		fs.addChild(root, a);
		fs.addChild(root, b);
		fs.addChild(root, c);
				
		visitor = new SizeCountingVisitor();
		root.accept(visitor);
		
		
	}
	
	@Test
	public void getTotalSize() {
		
		int expected = 40;
		int actual = visitor.getTotalSize();
		assertThat(actual, is(expected));
		System.out.println("Refer Test Cases:Size of file a+ file b+ file c =10+10+20");
		System.out.println(visitor.getTotalSize());
	}	
	 
	
}
