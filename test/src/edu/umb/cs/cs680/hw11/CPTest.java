package edu.umb.cs.cs680.hw11;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CPTest {

	FileSystem fs = FileSystem.getInstance();
	Directory c;
	Directory d;
	Directory programFiles;
	Directory pictures;
	File fa;

	@Before
	public void setup() {
		
		c = new Directory(fs.getRoot(), "c", "OwnerName");
		fs.addChild(fs.getRoot(), c);
		
		programFiles = new Directory(c, "programFiles", "OwnerName");
		fs.addChild(c, programFiles);
		
		d = new Directory(fs.getRoot(), "d", "OwnerName");
		fs.addChild(fs.getRoot(), d);
		
		pictures = new Directory(d, "pictures", "OwnerName");
		fs.addChild(d, pictures);
		
		fa = new File(c,"FileName","OwnerName",50);
		fs.addChild(c, fa);
	}

	@Test
	public void executeTest_cp() {
		fs.setCurrentDirectory(c);
		Command cd = new CP("FileName root/d");
		cd.execute();
		assertThat(d.getChildUsingName("FileName"), is(sameInstance(fa)));
	}

	
	
}
