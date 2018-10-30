package edu.umb.cs.cs680.hw11;

public class RMDIR implements Command{
	private Directory removeDir;
	private String s;
	private FileSystem fs;
	
	public RMDIR(String s) {
		this.s = s;
		this.fs=FileSystem.getInstance();
		
	}
	@Override
	public void execute() {
		removeDir = (Directory) fs.getElementFromfullPath(s);
		Directory parent = removeDir.getParent();
		parent.removeChild(removeDir);
		fs.showAllElements();
		return ;
	}

}
