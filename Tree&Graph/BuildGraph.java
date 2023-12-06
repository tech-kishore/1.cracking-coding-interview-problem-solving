package cci.graph.buildorder;

public class BuildGraph{  //  should be DAC graph

    BuildProject[] projects;
    
    public BuildGraph(String[] strProjects, String[][] strDependencies){
    	createProjects(strProjects);
    	createEdges(strDependencies);
    }

    private void createProjects(String[] strProjects) {
    	projects = new BuildProject[strProjects.length];
        for(int i=0;i<strProjects.length;i++){
        	projects[i] = new BuildProject(strProjects[i]);
        }
    }
    
    private void createEdges(String[][] dependencies) {
    	for(String[] d: dependencies) {
    		addEdge(d[0],d[1]);
    	}
    }

    private void addEdge(String strPproject, String strDependent) {
    	BuildProject project = getProject(strPproject);
    	BuildProject dependent = getProject(strDependent);
    	
        project.dependents[project.dependentsCount++]=dependent; // project must be completed 
                                                                 // before dependents
        dependent.parentsCount++; // specify dependent have parent(s)
    }
    
    // **** overhead | get Object from string
    // To Optimize this a HashMap can be used for fast retrieval based on key as project name
    private BuildProject getProject(String str) {
        for(BuildProject p: projects){
            if(p!=null && p.name.equals(str)){
                return p;
            }
        }
        return null;
    }

    //only for testing
    void traverse() {
        for(BuildProject project: projects){
            if (project.dependentsCount==0) {
                System.out.printf("%s - > [   ]\n",project.name);
                continue;
            }

            System.out.printf("%s - > [ ",project.name);
            for(BuildProject d: project.dependents){
                if (d!=null) {
                    System.out.printf("%s ",d.name);
                }
            }
            System.out.printf("]\n");
        }
	}
}
