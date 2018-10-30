package edu.umb.cs.cs680.hw11;

import java.util.ListIterator;
import java.util.Stack;

public class HISTORY implements Command{//Command History
	private CommandHistory history;
	private Stack<Command> commands;
	
	
	public HISTORY()
	{
		
	}
	
	@Override
	public void execute() 
	{		
		history = CommandHistory.getInstance();
		commands = history.getHistory();
		ListIterator<Command> li = commands.listIterator(commands.size());
		while(li.hasPrevious()) {
			  System.out.println(li.previous().getClass().getSimpleName());
			}

		return ;
	}

}
