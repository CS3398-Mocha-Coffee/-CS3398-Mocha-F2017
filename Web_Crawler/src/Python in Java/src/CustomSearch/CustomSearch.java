package CustomSearch;

import org.python.core.PyException;
import org.python.core.PyInstance;
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
		//FOR DEMO: SET FILEPATH TO YOUR COPY OF "customsearch.py"
		setFilePath("C:\\Users\\Mom\\Desktop\\Software Engineering\\-CS3398-Mocha-F2017\\Web_Crawler\\src\\pyScraper\\customsearch.py");
		//FOR DEMO: Install Jython 2.7.1b3 
		//put all outside modules inside of jython2.7.1b3/Lib/site-packages
		//I will try to implement so that you do not have to do this. 
		PythonInterpreter interpreter = new PythonInterpreter();
	    interpreter.execfile(getFilePath());
	    PyObject cSearch = interpreter.get("customSearch");
	    if (cSearch == null) {
            throw new Exception("Could not find Python function: " + cSearch);
        }
	    try {
	    	cSearch.__call__(new PyString(arg));
	    }catch(PyException e) {
	    	e.printStackTrace();
	    }
	    
	}
	public static void main(String[] args) throws Exception {
		customSearch("Noodles");
	}
	

}
