package edu.umb.cs.cs680.hw11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/*import hw11.fileSystem.Directory;
import hw11.fileSystem.File;
import hw11.fileSystem.FileSystem;
import hw11.fileSystem.Link;
*/
import org.junit.Before;

public class FileSystemTest {
	
	FileSystem fs = FileSystem.getInstance();
	Directory root,pictures,system,home;
	
	@Before
	public void setup() {
		root = new Directory(null, "root", "Raveena Mewani");
		fs.setRoot(root);

		
		 home = new Directory(root, "home", "Raveena Mewani");
		 system = new Directory(root, "system", "Raveena Mewani");
		 pictures = new Directory(home, "pictures", "Raveena Mewani");
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
		
		fs.addChild(system, a);
		fs.addChild(system, b);
		fs.addChild(system, c);			
		
		fs.addChild(home, pictures);
		fs.addChild(home, x);
		fs.addChild(home, d);		
		
		fs.addChild(pictures, y);
		fs.addChild(pictures, e);
		fs.addChild(pictures, f);	
		
	}
	@Test
	public void testGetFileSystem() 
	{
		FileSystem fileSystems = FileSystem.getInstance();
		assertThat("FileSystems is null.", fileSystems, is(notNullValue()));		
		FileSystem fileSystemss = FileSystem.getInstance();
		assertThat("Car is null.", fileSystemss, is(notNullValue()));		
		assertThat("Calculator violates properties.", fileSystems, is (sameInstance ( fileSystemss)));
	}
	
	@Test
	public void testshowAllElements() {
		fs.showAllElements();
		assertThat(true,is(true));
	}
	@Test
	public void testGetnSetRoot() {
		Directory newroot = new Directory(null, "newRoot", "Raveena");
		fs.setRoot(newroot);
		assertThat(fs.getRoot(), is (sameInstance (newroot)));
	}
	@Test
	public void testgetElementFromfullPath() {
		FSElement fe = fs.getElementFromfullPath("root/home/pictures");
		assertThat(fe, is (sameInstance (pictures)));
		fs.setCurrentDirectory(pictures);
		fe = fs.getElementFromfullPath("..");
		assertThat(fe, is (sameInstance (home)));
		
	}
	@Test
	public void testaddChild() {
		Directory newChild = new Directory(null, "newChild", "Raveena");
		fs.addChild(home, newChild);
		assertThat(home.getChildDirUsingName("newChild"), is (sameInstance (newChild)));
	}

}
