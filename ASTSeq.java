public class ASTSeq implements ASTNode {
    ASTNode lhs, rhs;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        lhs.typecheck(e);
        return rhs.typecheck(e);
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        lhs.eval(e);
        return rhs.eval(e);
    }

    public ASTSeq(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

}
