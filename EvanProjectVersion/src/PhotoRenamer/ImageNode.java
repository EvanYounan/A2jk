package PhotoRenamer;

import java.util.ArrayList;
import java.util.Random;

public class ImageNode extends FileNode {
	private ArrayList<Tag> tags;
	private long ID;
	Random x;
	
	public ImageNode(String path, String name) {
		super(path, name);
		this.tags = new ArrayList<>();
		x = new Random();
		this.ID = x.nextLong(); 
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public void removeTag(Tag tag) {
		tags.remove(tag);
	}
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}
	
	public boolean equals(ImageNode otherImgNode) {
		return this.ID == otherImgNode.ID;
	}

}
