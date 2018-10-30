package edu.umb.cs.cs680.hw11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

/*import hw11.fileSystem.Directory;
import hw11.fileSystem.File;
import hw11.fileSystem.FileSystem;
import hw11.fileSystem.Link;*/

import org.junit.Before;

public class DirectoryTest {
	FileSystem fs = FileSystem.getInstance();
	Directory root;
	
	@Before
	public void setup() {
		root = new Directory(null, "root", "Raveena Mewani");
		fs.setRoot(root);
		Directory home = new Directory(root,"home","Raveena Mewani");
		Directory system = new Directory(root,"system","Raveena Mewani");
		Directory pictures = new Directory(home,"pictures","Raveena Mewani");
		File a = new File(system, "a", "Raveena Mewani", 5);
		File b = new File(system, "b", "Raveena Mewani", 10);
		File c = new File(system, "c", "Raveena Mewani", 200);
		File d = new File(home, "d", "Raveena Mewani", 30);
		File e = new File(pictures, "e", "Raveena Mewani", 100);
		File f = new File(pictures, "f", "Raveena Mewani", 20);
		Link x = new Link(home, "x", "Raveena Mewani", system);
		Link y = new Link(pictures, "y", "Raveena Mewani", e);
		
		
		fs.setRoot(root);
		fs.addChild(root, system);		
		fs.addChild(root, home);
		
		fs.addChild(root, a);
		fs.addChild(root, b);
		fs.addChild(root, c);		
		
		fs.addChild(root, pictures);
		fs.addChild(root, x);
		fs.addChild(root, d);	
		
		
		fs.addChild(root, y);
		fs.addChild(root, e);
		fs.addChild(root, f);
		fs.showAllElements();
		
	}
	
	@Test
	public void testcountFSElements() {
		
		
		assertThat(root.countFSElements(),is(11));
	}
	
	@Test
	public void testgetTotalSize() {		
		
		assertThat(root.getTotalSize(),is(365));
	}
	@After
	public void afterTest() {
		System.out.println("---------------------------------------------------------------");
	}
}
