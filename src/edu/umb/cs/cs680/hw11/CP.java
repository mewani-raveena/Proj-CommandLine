package edu.umb.cs.cs680.hw11;


public class CP implements Command{
	private String s;
	private FileSystem fs;
	
	public CP(String s) {
		this.s = s;
		this.fs=FileSystem.getInstance();
		
	}
	@Override
	public void execute() {
		int l;
		if(s==null){
			System.out.println("Give Dir/File name(for copy) and Dir(destination) as a arg to copy");
			
		}
		else{
			String temp[] = s.split(" ");
			l=temp.length;
			
			if(l!=2) {
				System.out.println("There must be only two arguments");
				System.out.println("Give Dir/File name(for copy) and Dir(destination) as a arg to copy");
		
				return;
			}
			
				FSElement f = fs.getElementFromfullPath(temp[1]);
				FSElement ele = fs.getElementFromfullPath(temp[0]);
				if(f instanceof Directory && ele!=null) {
					Directory destinationDir = (Directory) f;
					ele.setParent(destinationDir);
					FSElement newElement = fs.getElementFromfullPath(temp[0]);
					fs.addChild(destinationDir, newElement);
					fs.showAllElements();

				}
				else {
					System.out.println("error check args");
				}
				 
		}
		
		return ;
		

	}
}
