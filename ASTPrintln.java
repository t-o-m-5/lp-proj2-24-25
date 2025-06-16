public class ASTPrintln implements ASTNode {
    ASTNode exp;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        exp.typecheck(e);
        return new ASTTUnit();
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v = exp.eval(e);
        System.out.println(v.toStr());
        return v;
    }

    public ASTPrintln(ASTNode e) {
        exp = e;
    }

}
