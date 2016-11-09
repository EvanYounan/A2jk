package PhotoRenamer;

public abstract class FileNode {
	private String pathName;
	private String name;
	
	public FileNode(String path, String name) {
		this.pathName = path;
		this.name = name;
	}
	
	public String getPathName() {
		return pathName;
	}


	public void setPathName(String pathName) {
		this.pathName = pathName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}
