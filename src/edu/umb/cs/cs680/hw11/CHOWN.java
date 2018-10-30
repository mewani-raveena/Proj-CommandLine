package edu.umb.cs.cs680.hw11;

public class CHOWN implements Command{//Change OWNER
	
	private FileSystem fs;
	private String s;
	
	public CHOWN(String s) {
		this.s = s;
		this.fs=FileSystem.getInstance();
	}
	
	
	@Override
	public void execute() {
		int l;
		if(s==null){
			System.out.println("Give the Owner name and Directory/File Name as a argument to change Owner for specific directory/file");
			System.out.println("one arg will change owner name of current dir");
		}
		else{
			String temp[] = s.split(" ");
			l=temp.length;		
			
			if(l==1) {
				fs.getCurrentDirectory().setOwner(temp[0]);
			}else if(l>1) {
				
				FSElement ele =  fs.getElementFromfullPath(temp[1]);
				if(ele!=null) {
					ele.setOwner(temp[0]);
				}else {
					System.out.println("No such dir found arg order is 'newName'  'elementPath' ");
				}
				
			}
		}

		return ;
		
	}
}
