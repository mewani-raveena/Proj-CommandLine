package edu.umb.cs.cs680.hw11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;

public class FileIndexingVisitorTest {

	FileSystem fs = FileSystem.getInstance();
	Directory root;
	FileIndexingVisitor visitor;
	@Before
	public void setup() {
		root = new Directory(null, "root", "Raveena Mewani");
		fs.setRoot(root);
		File a = new File(root, "a", "Raveena Mewani", 10);
		File b = new File(root, "b","Raveena Mewani", 10);
		File c = new File(root, "c","Raveena Mewani",20);
		Link x = new Link(root, "x", "Raveena Mewani",a);
		
		fs.setRoot(root);
		fs.addChild(root, a);
		fs.addChild(root, b);
		fs.addChild(root, c);
		fs.addChild(root, x);
		visitor = new FileIndexingVisitor();
		root.accept(visitor);
		
	}
	
	@Test
	public void getIndexedFileNum() {
		int expected = 3;
		int actual = visitor. getIndexedFileNum();
		assertThat(actual, is(expected));
	}

}
