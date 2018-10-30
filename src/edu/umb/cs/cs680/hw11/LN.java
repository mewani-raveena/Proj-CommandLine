package edu.umb.cs.cs680.hw11;


public class LN implements Command{//Make Link
	Directory target;
	String linkName;
	private FileSystem f;
	private String s;
	
	public LN(String s) {
		f = FileSystem.getInstance();
		this.s = s;
	}
	
	@Override
	public void execute() {
		
		int l;
		if(s==null){
			System.out.println("Give the target directory/filename and link name as a argument to make link");
			
		}
		else{
			String temp[] = s.split(" ");
			l=temp.length;
			
			if(l!=2) {
				System.out.println("There must be only two arguments");
				System.out.println("Give the target directory/filename and link name as a argument to make link");
				return;
			}
			
				FSElement target = f.getElementFromfullPath(temp[0]);
				if(target!=null) {
					Link link = new Link(f.getCurrentDirectory(),temp[1],"XXXX",target);
					f.addChild(f.getCurrentDirectory(), link);
					f.showAllElements();
					System.out.println("\n");
				}
				else
				{
					System.out.println("No such directory/file exits");
				}
			
		}

		return ;
		
	}

}
