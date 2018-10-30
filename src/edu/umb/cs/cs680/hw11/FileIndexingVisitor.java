package edu.umb.cs.cs680.hw11;

public class FileIndexingVisitor implements FSVisitor{
	
	private int indexedFileNum=0;
	
	@Override
	public void visit(Link link) 
	{
		return;
	}

	@Override
	public void visit(Directory dir) 
	{
		return;
	}

	@Override
	public void visit(File file) 
	{
		System.out.println("FileIndexing Visit File Name:  "+file.getName());		
		indexedFileNum++;
	}
	public int getIndexedFileNum() {
		return indexedFileNum;
	}

}
