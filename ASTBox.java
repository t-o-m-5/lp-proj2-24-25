public class ASTBox implements ASTNode {
    ASTNode v;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        return new ASTTRef(v.typecheck(e));
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue value = v.eval(e);

        return new VCell(value);
    }

    public ASTBox(ASTNode v) {
        this.v = v;
    }

}