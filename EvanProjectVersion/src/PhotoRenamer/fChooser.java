package PhotoRenamer;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class fChooser {
	JFileChooser fc;
	
	public fChooser() {
		fc = new JFileChooser();
	}
	
	public File getFile() {
	    
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG, GIF, PNG, and TIFF Images", "jpg", "gif", "png", "tif");
	    
		fc.setFileFilter(filter);
	    fc.showOpenDialog(null);
	    return fc.getSelectedFile();
	}
	
	public File[] getFiles() {
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG, GIF, PNG, and TIFF Images", "jpg", "gif", "png", "tif");
		    
		fc.setFileFilter(filter);
		fc.setMultiSelectionEnabled(true);
		fc.showOpenDialog(null);
		return fc.getSelectedFiles();
	}

}
