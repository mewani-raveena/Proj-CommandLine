package edu.umb.cs.cs680.hw11;

import java.util.Scanner;

public class Shell {
	private static CommandHistory commandhistory = CommandHistory.getInstance();
	
	public Shell()
	{
		
	}
	public static void main(String[] args) throws Exception
	{
		FileSystem fs = FileSystem.getInstance();
		fs.createFileSystem();
		
		System.out.println("\n");
		System.out.println("WelCome to Shell Script. Try cmds on above shown \n");
		System.out.println("Press return/enter to get brief description of commands");
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("\n");
			Command pwd = new PWD();
			pwd.execute();
			System.out.println(" Shell>");
			String commandStr = in.nextLine().trim();
			
			execute(commandStr);
		}
	}
	public static void execute(String s)	
	{	
		String command[] = s.split(" ");
		int len = command.length;
		Command commandInstance = null;
		String c = command[0].toUpperCase();
	
		if(c.contains("PWD"))
		{			
			commandInstance = new PWD();			
		}		
		else if(c.equalsIgnoreCase("CD") && (len==1)) 
		{
			commandInstance = new CD();			
		}
		else if(c.equalsIgnoreCase("CD") && len>1)
		{	
			commandInstance = new CD(command[1]);		
		}
		else if(c.equalsIgnoreCase("LS"))
		{
			commandInstance = new LS();			
		}
		else if(c.equalsIgnoreCase("DIR") && len>1)
		{			
			commandInstance = new DIR(command[1]);			
		}
		else if(c.equalsIgnoreCase("DIR")&& len == 1)
		{
			commandInstance = new DIR();			
		}
		else if(c.equalsIgnoreCase("MKDIR") && len>1)
		{		
			commandInstance = new MKDIR(command[1]);
		}		
		else if(c.equalsIgnoreCase("RMDIR") && len>1)
		{			
			commandInstance = new RMDIR(command[1]);			
		}		
		else if(c.equalsIgnoreCase("LN") && len>2)
		{
			commandInstance = new LN (command[1] +" "+ command[2]);			
		}
		else if(c.equalsIgnoreCase("MV") && len>2)
		{
			commandInstance = new MV (command[1] +" "+ command[2]);			
		}
		else if(c.equalsIgnoreCase("CP") && len>2)
		{
			commandInstance = new CP (command[1] +" "+ command[2]);			
		}
		else if(c.equalsIgnoreCase("CHOWN") && len==2)
		{
			commandInstance = new CHOWN(command[1]);	
		}else if(c.equalsIgnoreCase("CHOWN") && len==3)
		{
			commandInstance = new CHOWN(command[1] +" "+ command[2]);	
		}
		else if(c.equalsIgnoreCase("HISTORY"))
		{
			commandInstance =new HISTORY();			
		}
		else if(c.equalsIgnoreCase("REDO"))
		{
			commandInstance =new REDO();			
		}		
		else if(c.equalsIgnoreCase("SORT") && len>1)
		{			
			commandInstance =new SORT(command[1]);			
		}
		else if(c.equalsIgnoreCase("SORT") && len==1)
		{
			commandInstance = new SORT("");
		}else if(c.equalsIgnoreCase("SHOW")){
			FileSystem.getInstance().showAllElements();
		}
		else if(c.equalsIgnoreCase("EXIT")){
			System.exit(0);
		}
		else{
			System.out.println("Invalid Command.......\n");
			System.out.println("----------------------------------------------------\n");
			System.out.println("PWD\r\n" + "Print the current working dir.\r\n\n" + 
					"CD dirName\r\n" +"Change the current directory to the specified dir.\r\n" + 
					"(move to the parent dir of the current dir.) \r\n\n" + 
					"CD\r\n" +"Change the current directory to the root directory.\r\n\n" + 
					"LS\r\n" +"List names of every files, directories and links in the current dir.\r\n\n" + 
					"DIR\r\n" + 
					"Print info (i.e., kind, name, size and owner) of every file, directory and link in the current dir.\r\n\n" + 
					"DIR dir/fileName \r\n" + 
					"Print the specified directory(s)/file(s) info. \r\n\n" + 
					"MKDIR dirName\r\n" + 
					"Make the specified dir in the current dir.\r\n\n" + 
					"RMDIR dirName \r\n" + 
					"Remove the specified dir in the current dir.\r\n\n" + 
					"LN target (real) dir/file link(alias)Name\r\n" + 
					"Make a link\r\n\n" + 
					"MV dir/file DestinationDirPath \r\n" + 
					"Move a directory/file to DestinationDirPath \r\n\n" + 
					"CP dir/file destinationDirPath\r\n" + 
					"copy a dir/file to DestinationDirPath  \r\n\n" + 
					"CHOWN newName DirPath \r\n" + 
					"Change the owner of a file/directory\r\n\n" + 
					"HISTORY\r\n" + 
					"Print a sequence of previously-executed commands.\r\n\n" + 
					"REDO\r\n" + 
					"Redo the most recently-executed command.\r\n\n" + 
					"SORT \r\n" + 
					"Sort directories and files in the current directory \n\n"+
					"EXIT \r\n" + 
					"Exit from shell \n\n"+
					"SHOW \r\n" + 
					"show directory structure \n\n");
			System.out.println("----------------------------------------------------\n");
			return;
		}
		try {
			if(commandInstance != null) {
				commandInstance.execute();
				commandhistory.push(commandInstance);			
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR ... Check your args and commands\n");
			System.out.println(e);
		}
		
		
		
	}
	
	
}
