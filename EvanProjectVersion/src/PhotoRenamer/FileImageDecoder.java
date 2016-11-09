package PhotoRenamer;

import java.io.File;
import java.util.ArrayList;

public class FileImageDecoder {
	
	ArrayList<File> files;
	ImageHandler imgH;
	
	public FileImageDecoder(ArrayList<File> files) {
		this.files = files;
		imgH = new ImageHandler();
		initialize();
	}

	public void initialize() {
		for (File file : files) {
			imgH.addImageNode(new ImageNode(
					file.getAbsolutePath(), file.getName()));
		}
		System.out.println(imgH);
	}
	
	public ArrayList<File> getFiles() {
		return this.files;
	}
	
	public ArrayList<ImageNode> toImageNodes() {
		ArrayList<ImageNode> imgNodes = new ArrayList<ImageNode>();
		for (File file : this.files) {
			imgNodes.add(new ImageNode(file.getAbsolutePath(), file.getName()));
		}
		return imgNodes;
	}
	
	public ArrayList<String> getImagePaths() {
		ArrayList<String> temp = new ArrayList<String>();
		for (File file : files) {
			temp.add(file.getAbsolutePath());
		}
		return temp;
	}
	
}
