package cci.graph.buildorder;

public class BuildProject {
	// all this fields should be private and only be accessed by relevant public getter methods; 
	public String name;
	public boolean visited;
	public int parentsCount;
	public BuildProject[] dependents = new BuildProject[10]; // make this fixed length to dynamic
															 // ArrayList can be used for better memory management
															 // I am just Lazy to re-factor!
	public int dependentsCount;

	public BuildProject(String str) {
		this.name=str;
	}
}