public class ASTAssign implements ASTNode {
    ASTNode exp, value;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v1 = exp.eval(e);
        IValue v2 = value.eval(e);

        if (v1 instanceof VCell) {
            ((VCell)v1).set(v2);
            return v2;
        } else {
            throw new InterpreterError(":= operator: reference expected, found "+v1.toStr());
        }
    }

    public ASTAssign(ASTNode exp, ASTNode value) {
        this.exp = exp;
        this.value = value;
    }

}