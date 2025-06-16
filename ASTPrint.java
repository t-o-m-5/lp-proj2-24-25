public class ASTPrint implements ASTNode {
    ASTNode exp;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        exp.typecheck(e);
        return new ASTTUnit();
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v = exp.eval(e);
        System.out.print(v.toStr());
        return v;
    }

    public ASTPrint(ASTNode e) {
        exp = e;
    }

}
