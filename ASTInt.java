public class ASTInt implements ASTNode  {
    int v;

    public ASTType typecheck(Environment<ASTType> e) {
        return new ASTTInt();
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
	    return new VInt(v);                
    }

    ASTInt(int v0) {
        v = v0;
    }

}
