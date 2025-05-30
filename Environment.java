import java.util.*;

public class Environment <E>{
    Environment<E> anc;
    Map<String, E> bindings;

    Environment(){
        anc = null;
        bindings = new HashMap<String,E>();
    }
    
    Environment(Environment<E> ancestor){
	    anc = ancestor;
        bindings = new HashMap<String, E>();
    }

    Environment<E> beginScope(){
        return new Environment<E>(this);
    }

    Environment<E> endScope(){
        return anc;
    }

    void assoc(String id, E bind) throws InterpreterError {
        if (bindings.containsKey(id)) {
            throw new InterpreterError("id already in environment"); 
        } else {
            bindings.put(id, bind);
        }
    }

    E find(String id) throws InterpreterError {
        E res = bindings.get(id);
        
        if (anc != null) {
            return res != null ? res : anc.find(id);
        } else if (res != null) {
            return res;
        } else {
            throw new InterpreterError("id not found");
        }        
    }

}
