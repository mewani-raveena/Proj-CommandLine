package edu.umb.cs.cs680.hw11;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SORT implements Command {
	private String sortingMethod;
	FileSystem fs;

	public SORT(String sortingMethod) {
		this.sortingMethod = sortingMethod;
		fs = FileSystem.getInstance();
	}

	@Override
	public void execute() {

		LinkedList<FSElement> childrens = (LinkedList<FSElement>) fs.getCurrentDirectory().getChildren().clone();

		if (this.sortingMethod.contentEquals("")) {


		} else if (this.sortingMethod.contentEquals("alphabetical")) {
			
		} else if (this.sortingMethod.contentEquals("reversealphabetical")) {
			Collections.sort(childrens, new ReverseAlphabeticalComparator());

		} else if (this.sortingMethod.contentEquals("timestamp")) {
			Collections.sort(childrens, new TimeStampComparator());

		} else if (this.sortingMethod.contentEquals("element")) {
			int startFileIndex = java.lang.Integer.MAX_VALUE, endFileIndex = 0, count = 0;
			Collections.sort(childrens, new ElementKindComparator());
			for (int i = 0; i < childrens.size(); i++) {
				if (childrens.get(i).getType() == "File") {
					if (startFileIndex < i) {
						startFileIndex = i;
					}
					count++;
				}

			}
			if(startFileIndex<java.lang.Integer.MAX_VALUE) {
				endFileIndex = startFileIndex + count;
				List subFileList = childrens.subList(startFileIndex,endFileIndex);
				Collections.sort(subFileList, new ElementKindComparator());
			}
			
			

		} else {
			System.out.println("Possible sorting stretage could be: alphabetical, reversealphabetical, timestamp, element");
		}
		for (int i = 0; i < childrens.size(); i++) {
			
			System.out.println(childrens.get(i).getName()+" ,  "+childrens.get(i).getType());
		}
		
		return ;
	}
}
