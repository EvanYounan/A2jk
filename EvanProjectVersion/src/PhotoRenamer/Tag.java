package PhotoRenamer;

public class Tag {
	private String name;
	private String time;
	
	public Tag(String name) {
		this.name = name;
	}

	public boolean equals(Tag otherTag) {
		return this.getName().equals(otherTag.getName());
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "Tag " + this.name;
	}
}
