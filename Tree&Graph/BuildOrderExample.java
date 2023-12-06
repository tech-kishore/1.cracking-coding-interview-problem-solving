package cci.graph.buildorder;

import java.util.LinkedList;

class BuildOrderExample {
    public static void main(String[] args) {

    	String[] iProjects = {"a","b","c","d","e","f"};
        String[][] iDependencies = {
            {"a","d"},
            {"f","b"},
            {"b","d"},
            {"f","a"},
            {"d","c"}
        };

        BuildGraph g = new BuildGraph(iProjects, iDependencies);

        // traverse graph for TESTING(temporary)
        g.traverse();
        System.out.println("===================== BUILD ORDER ======================");

        // work on this method; First test above ????????
		String[] order = new BuildOrderExample().createBuildOrder(g);

		for(String p:order){ 
			System.out.printf("%s ",p); 
		}
		
        System.out.println("\n===================== xxxxxxxxxxx ======================");
       
    }

    // using BFS
    public String[] createBuildOrder(BuildGraph graph){
        String[] order = new String[graph.projects.length];
        int offset = 0;

        LinkedList<BuildProject> queue = new LinkedList<>();
        
        // find eligible build projects to start out
        findProjectsWithNoParents(graph, queue);

        // if no independent nodes/projects found i.e queue is empty at this point to start with 
        // Cyclic dependency is detected; Build not possible.
        if(queue.isEmpty()) {
        	return new String[] {};
        }

        while(!queue.isEmpty()){

        	BuildProject r = queue.pollFirst();

            // Ordering build eligible projects
            if(r.parentsCount==0){
                order[offset++] = r.name;
                r.visited=true; // CHECK IF THIS IS NECESSARY
            }
            
            // loop thru its dependencies
            for(BuildProject dependent: r.dependents){
               
            	if(dependent == null)
                    continue;
            	
            	dependent.parentsCount--;

                if(!dependent.visited){
                    queue.add(dependent);
                    dependent.visited=true;
                }
            }
            
            /* Detect cycle
             * ------------
             * if all projects has not been traversed and still the processing Queue is Empty
             * because there is no node(project) with dependencies i.e parents then a 
             * cyclic dependency is detected. Build Not Possible!
             * */
            boolean pendingProjectsToVisit =  offset<(graph.projects.length);
            
            if(pendingProjectsToVisit && queue.isEmpty()) {
            	return new String[] {};
            }
            
        }
        return order;
    }
    
    // find all projects with no dependencies i.e; no parents
    private void findProjectsWithNoParents(BuildGraph graph, LinkedList<BuildProject> q) {
	  for(BuildProject p:graph.projects){
		if(!p.visited && p.parentsCount==0) {
			q.add(p);
		}
	  }
	}
}



