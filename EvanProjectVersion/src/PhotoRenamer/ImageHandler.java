package PhotoRenamer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ImageHandler implements Serializable {

	Map<ImageNode, ArrayList<Tag>> existing;
	Map<ImageNode, ArrayList<Tag>> removed;
	
	public ImageHandler() {
		existing = new HashMap<ImageNode, ArrayList<Tag>>();
		removed = new HashMap<ImageNode, ArrayList<Tag>>();
	}
	
	public ImageHandler(HashMap<ImageNode, ArrayList<Tag>> exis, HashMap<
			ImageNode, ArrayList<Tag>> removed) {
		this.existing = exis;
		this.removed = removed;
	}
	
	public void addImageNode(ImageNode imgNode) {
		existing.put(imgNode, new ArrayList<Tag>());
	}
	
	public void removeImageNode(ImageNode imgNode) {
		existing.remove(imgNode);
	}
	
	public boolean isInExisting(ImageNode imgNode) {
		for (ImageNode tempImgNode : existing.keySet()) {
			if (tempImgNode.getID() == imgNode.getID()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInRemoved(ImageNode imgNode) {
		for (ImageNode tempImgNode : removed.keySet()) {
			if (tempImgNode.getID() == imgNode.getID()) {
				return true;
			}
		}
		return false;
	}
	
	public void addTag(ImageNode imgNode, Tag tag) {
		imgNode.addTag(tag);
		if (isInExisting(imgNode)) {
			existing.get(imgNode).add(tag);
		}
	}
	
	public void removeTag(ImageNode imgNode, Tag tag) {
		imgNode.removeTag(tag);
		if (isInExisting(imgNode)) {
			removed.put(imgNode, new ArrayList<Tag>());
			removed.get(imgNode).add(tag);
			existing.get(imgNode).remove(tag);
		}
	}
	
	public String toString() {
		String retString = "Existing:";
		for (ImageNode img : existing.keySet()) {
			retString += img.getName() + " [";
			for (Tag tag : existing.get(img)) {
				retString += tag.getName() + " ";
			}
			retString += "] ";
		}
		retString += "\n" + "Removed: "; 
		for (ImageNode img : removed.keySet()) {
			retString += img.getName() + " [";
			for (Tag tag : removed.get(img)) {
				retString += tag.getName() + " ";
			}
			retString += "] ";
		}
		
		return retString;
	}
	
	public static void main(String[] args) {
		Tag t = new Tag("Evan");
		ImageNode i = new ImageNode("w/e/path/thisFile.jpg", "thisFile");
		ImageHandler imgH = new ImageHandler();
		imgH.addImageNode(i);
		imgH.addTag(i, t);
		System.out.println(imgH);
		
		Tag m = new Tag("Marvin");
		
		imgH.addTag(i, m);
		System.out.println(imgH);
		
		imgH.removeTag(i, m);
		System.out.println(imgH);
	
		for (ImageNode img : imgH.existing.keySet()) {
			for (ImageNode removedImg : imgH.removed.keySet()) {
				System.out.println(img.equals(removedImg));
			}
		}
		
	}
}
