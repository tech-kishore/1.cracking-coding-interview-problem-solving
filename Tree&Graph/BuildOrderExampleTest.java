package cci.graph.buildorder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuildOrderExampleTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test_createBuildOrder() {
		String[] iProjects = {"a","b","c","d","e","f"};
		
        String[][] iDependencies = {
            {"a","d"},
            {"f","b"},
            {"b","d"},
            {"f","a"},
            {"d","c"}
        };
        
        BuildOrderExample obj = new BuildOrderExample();
        
		BuildGraph g = new BuildGraph(iProjects, iDependencies);
		
		String[] expected = {"e", "f", "b", "a", "d", "c" };
		String[] actual = obj.createBuildOrder(g);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void test_createBuildOrder_whenCyclic_withIndependentNodes_No_build_Possible_Empty_Order() {
		 String[] iProjects = {"a","b","c","f","e"}; // cyclic but free node present
	        String[][] iDependencies = {
	                {"b","f"},
	                {"f","c"},
	                {"c","a"},
	                {"a","b"}
	        };
        
        BuildOrderExample obj = new BuildOrderExample();
        
		BuildGraph g = new BuildGraph(iProjects, iDependencies);
		
		String[] expected = {};
		String[] actual = obj.createBuildOrder(g);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void test_createBuildOrder_whenCyclic_withNoIndependentNodes_No_build_Possible_Empty_Order() {
		 String[] iProjects = {"a","b","c","f"}; // cyclic but free node present
	        String[][] iDependencies = {
	                {"b","f"},
	                {"f","c"},
	                {"c","a"},
	                {"a","b"}
	        };
        
        BuildOrderExample obj = new BuildOrderExample();
        
		BuildGraph g = new BuildGraph(iProjects, iDependencies);
		
		String[] expected = {};
		String[] actual = obj.createBuildOrder(g);
		
		assertArrayEquals(expected, actual);
	}


}
