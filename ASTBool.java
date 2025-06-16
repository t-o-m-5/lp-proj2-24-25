public class ASTBool implements ASTNode {
    
    boolean b;

    public ASTType typecheck(Environment<ASTType> e) {
        return new ASTTBool();
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VBool(b);
    }

    ASTBool(boolean b0) {
        b = b0;
    }
    
}