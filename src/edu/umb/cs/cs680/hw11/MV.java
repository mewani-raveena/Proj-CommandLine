package edu.umb.cs.cs680.hw11;

public class MV implements Command{
	private String s;
	private FileSystem fs;
	
	public MV(String s) {//move
		this.s = s;
		this.fs=FileSystem.getInstance();
	}
	@Override
	public void execute() {
		
		
		int l;
		if(s==null){
			System.out.println("Give the target directory/filename to move and dir destination ");
		}
		else{
			String temp[] = s.split(" ");
			l=temp.length;
			
			if(l!=2) {
				System.out.println("There must be only two arguments");
				System.out.println("Give the target directory/filename to move and dir destination ");
				return;
			}
			
				FSElement f = fs.getElementFromfullPath(temp[1]);
				FSElement newElement = fs.getElementFromfullPath(temp[0]);
				
				if(f instanceof Directory) {
					Directory destinationDir = (Directory) f;
					
					newElement.getParent().removeChild(newElement);					
					newElement.setParent(destinationDir);					
					fs.addChild(destinationDir, newElement);
					fs.showAllElements();
				}
				else
				{
					System.out.println("error check args");
				}
					
		}
		
		return ;
		

	}
}
