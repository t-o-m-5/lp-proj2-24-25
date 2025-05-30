public class ASTPrint implements ASTNode {
    ASTNode exp;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v = exp.eval(e);
        System.out.print(v.toStr());
        return v;
    }

    public ASTPrint(ASTNode e) {
        exp = e;
    }

}
