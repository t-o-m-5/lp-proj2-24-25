public class ASTDeref implements ASTNode {
    ASTNode exp;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType te = exp.typecheck(e);
        te = TypeUtils.resolveType(te, e);
        if (te instanceof ASTTRef) {
            return ((ASTTRef)te).getType();
        } else {
            throw new TypeCheckError("! operator: type ref expected, found "+te.toStr());
        }
    }

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
