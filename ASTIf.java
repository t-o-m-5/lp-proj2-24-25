public class ASTIf implements ASTNode {
    ASTNode cond, b1, b2;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType tc = cond.typecheck(e);
        tc = TypeUtils.resolveType(tc, e);
        ASTType tb1 = b1.typecheck(e);
        tb1 = TypeUtils.resolveType(tb1, e);
        ASTType tb2 = b2.typecheck(e);
        tb2 = TypeUtils.resolveType(tb2, e);
        if (tc instanceof ASTTBool) {
            if (tb1.equals(tb2, e)) {
                return tb1;
            } else {
                throw new TypeCheckError("if operator: expected same types on both branches, found "+tb1.toStr()+" "+tb2.toStr());
            }
        } else {
            throw new TypeCheckError("if operator: type bool expected in condition, found "+tc.toStr());
        }
    }

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