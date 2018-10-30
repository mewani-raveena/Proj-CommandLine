package edu.umb.cs.cs680.hw11;

public class REDO implements Command{
	private CommandHistory history;
	private Command c;
	
	public REDO() {
		
	}
	@Override
	public void execute() {
		history = CommandHistory.getInstance();
		c = history.getHistory().pop();
		System.out.println(c.getClass().getSimpleName());
		
		c.execute();
		return ;
	}
}
