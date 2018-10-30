package edu.umb.cs.cs680.hw11;

public class MKDIR implements Command{
	String dirName;
	private FileSystem f;
	
	public MKDIR(String dirName) {
		this.dirName = dirName;
		f = FileSystem.getInstance();
	}
	
	@Override
	public void execute() {
		
		Directory dir = new Directory(f.getCurrentDirectory(),dirName,"");		
		f.addChild(f.getCurrentDirectory(), dir);
		f.showAllElements();
		return ;
	}

}
