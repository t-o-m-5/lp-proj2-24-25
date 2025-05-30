public class ASTDeref implements ASTNode {
    ASTNode exp;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v = exp.eval(e);

        if (v instanceof VCell) {
            return ((VCell)v).get();
        } else {
            throw new InterpreterError("! operator: reference expected, found "+v.toStr());
        }
    }

    public ASTDeref(ASTNode exp) {
        this.exp = exp;
    }

}
