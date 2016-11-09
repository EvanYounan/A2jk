package PhotoRenamer;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {
	private ArrayList<File> files;
	
	public FileHandler(boolean cond) {
		fChooser jfc = new fChooser();
		if (cond) {
			files = new ArrayList<File>();
			files.add(jfc.getFile());
		} else {
			files = new ArrayList<File>(Arrays.asList(jfc.getFiles()));
		}
	}
	
	public ArrayList<File> getFiles() {
		return files;
	}
	
//	public String toString() {
//		String retString = "";
//		for (File file : files) {
//			retString += file.getName() + ", ";
//		}
//		return retString;
//	}
	
}
