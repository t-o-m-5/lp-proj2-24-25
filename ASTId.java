public class ASTId implements ASTNode	{	

    String id;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        return e.find(id);
    }
    
    public ASTId(String id)	{
        this.id = id;
    }

    public IValue eval(Environment<IValue> env)	throws InterpreterError {
        return env.find(id);	
    }

}	
