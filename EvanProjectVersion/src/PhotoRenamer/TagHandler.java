//package PhotoRenamer;
//
//import java.util.Map;
//import java.util.Random;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashMap;
//
///** A TagHandler to handle existing and removed tags. This class
// * is also Serializable as we need to save these objects for 
// * reuse use of the program. 
// */
//public class TagHandler implements Serializable {
//	
//	Map<Tag, ArrayList<Long>> existing;
//	Map<Tag, ArrayList<Long>> removed;
//	
//	public TagHandler() {
//		existing = new HashMap<Tag, ArrayList<Long>>();
//		removed = new HashMap<Tag, ArrayList<Long>>();
//	}
//	
//	public TagHandler(HashMap<Tag, ArrayList<Long>> exis, HashMap<
//			Tag, ArrayList<Long>> removed) {
//		this.existing = exis;
//		this.removed = removed;
//	}
//	
//	public boolean addTag(Tag tag, long ID) {
//		for (Tag exisTag : existing.keySet()) {
//			if (tag.equals(exisTag)) {
//				existing.get(exisTag).add(ID);
//				return true;
//			}
//		}
//		existing.put(tag, new ArrayList<Long>());
//		return existing.get(tag).add(ID);
//	}
//	
//	public boolean removeTag(Tag tag) {
//		for (Tag exisTag : existing.keySet()) {
//			if (tag.equals(exisTag)) {
//				addRemovedTagWithIDs(exisTag, existing.get(exisTag));
//				existing.remove(exisTag);
//				return true;
//			}
//		}
//		System.out.println("Could not remove the tag");
//		return false;
//	}
//	
//	
//	/**
//	 * Remove an ID from all existing Tags.
//	 * @param tag Tag
//	 * @param ID long
//	 * @return
//	 */
//	public void removeID(long ID) {
//		for (Tag exisTag : existing.keySet()) {
//			if (existing.get(exisTag).contains(ID)) {
//				existing.get(exisTag).remove(ID);
//			}
//		}
//	}
//	
//	
//	public boolean addRemovedTagWithIDs(Tag tag, ArrayList<Long> IDs) {
//		for (Tag removedTag : removed.keySet()) {
//			if (tag.equals(removedTag)) {
//				for (long ID : IDs) {
//					removed.get(removedTag).add(ID);
//				}
//				return true;
//			}
//		}
//		removed.put(tag, IDs);
//		return true;
//	}
//	/**
//	 * Add a tag to the removed list with the given ID. If the Tag 
//	 * is already an element in the removed 
//	 * @param tag
//	 * @param ID
//	 * @return
//	 */
//	public boolean addRemovedTagWithID(Tag tag, long ID) {
//		for (Tag removedTag : removed.keySet()) {
//			if (tag.equals(removedTag)) {
//				removed.get(removedTag).add(ID);
//				return true;
//			}
//		}
//		removed.put(tag, new ArrayList<Long>());
//		return removed.get(tag).add(ID);
//	}
//	
//	public String toString() {
//		String retString = "Existing: ";
//		for (Tag currTag : existing.keySet()) {
//			retString += currTag + " [";
//			for (long lng : existing.get(currTag)) {
//				retString += lng + ", ";
//			}
//			retString += "] ";
//		}
//		retString += "\n" + "Removed: ";
//		for (Tag removedTag : removed.keySet()) {
//			retString += removedTag + " [";
//			for (long lng : removed.get(removedTag)) {
//				retString += lng + ", ";
//			}
//			retString += "] ";
//		}
//		return retString;
//	}
//	//Testing using examples from main
//	public static void main(String[] args) {
////		Tag x = new Tag("Evan");
////		TagHandler y = new TagHandler();
////		
////		System.out.println("Adding tag [Evan] with ID 2323");
////		y.addTag(x, 2323l);
////		System.out.println(y);
////		
////		System.out.println("Creating tag Marvin and adding it with ID 2332");
////		Tag m = new Tag("Marvin");
////		y.addTag(m, 2332l);
////		System.out.println(y);
////		
////		System.out.println("Adding tag [Evan] with ID 53243234");
////		y.addTag(new Tag("Evan"), 53243234l);
////		System.out.println(y);
////		
////		System.out.println("Adding tag [Marvin] with ID 2323..");
////		y.addTag(new Tag("Marvin"), 2323l);
////		System.out.println(y);
////		
////		System.out.println("Removing a certain ID from all tags");
////		y.removeID(2323);
////		System.out.println(y);
////		
////		System.out.println("Removing tag Evan");
////		y.removeTag(x);
////		System.out.println(y);
//		
//		//Example 2
////	ImageNode i = new ImageNode("W.e/path/Evan.jpg", "Evan");
////	Tag x = new Tag("Evan");
////	TagHandler y = new TagHandler();
////	y.addTag(x, i.getID());
////	System.out.println(y);
//	}
//
//}
