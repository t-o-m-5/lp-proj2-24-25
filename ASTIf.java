public class ASTIf implements ASTNode {
    ASTNode cond, b1, b2;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue c = cond.eval(e);

        if (c instanceof VBool) {
            if (((VBool)c).getval() == true) {
                return b1.eval(e);
            } else {
                return b2.eval(e);
            }
        } else {
            throw new InterpreterError("if operator: expected boolean, found "+c.toStr());
        }
    }

    public ASTIf(ASTNode cond, ASTNode b1, ASTNode b2) {
        this.cond = cond;
        this.b1 = b1;
        this.b2 = b2;
    }

}