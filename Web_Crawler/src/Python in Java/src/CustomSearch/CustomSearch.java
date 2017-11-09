package CustomSearch;

import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class CustomSearch {
	private static String filepath;
	private static String function;
	private static String arg;
	
	public static void setFilePath(String pathToScript) {
		filepath = pathToScript;
	}
	
	public static String getFilePath() {
		return filepath;
	}
	
	
	public static void customSearch (String arg) throws Exception {
		//FOR Integration: Download PyDev package in eclipse
		
		/*FOR Integration: JYTHON
		  1) Go to Eclipse preferences and search 'Jython' in filter
		  2) click on 'Jython Interpreter'
		  3) click 'New'
		  4) *Interpreter Name: call it what you want
		     *Interpreter Executable: jython2.7.1b3/jython.jar
		  5) Click 'Apply' 
		*/
		
		//FOR Integration: SET FILEPATH TO YOUR COPY OF "customsearch.py" (ONLY IF customsearch.py IS NOT FOUND)
		setFilePath("../pyScraper/customsearch.py");
		PythonInterpreter interpreter = new PythonInterpreter();
	    interpreter.execfile(getFilePath());
	    PyObject cSearch = interpreter.get("customSearch"); //name of the Python function
	    if (cSearch == null) {
            throw new Exception("Could not find Python function: " + cSearch);
        }
	    try {
	    	cSearch.__call__(new PyString(arg));
	    }catch(PyException e) {
	    	e.printStackTrace();
	    }
	    
	    interpreter.close();
	    
	}
	public static void main(String[] args) throws Exception {
		customSearch("Spaghetti");    
	}
	

}
