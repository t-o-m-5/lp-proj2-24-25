
public interface ASTNode {

    ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError;
    IValue eval(Environment<IValue> e) throws InterpreterError;

}

