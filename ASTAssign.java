public class ASTAssign implements ASTNode {
    ASTNode exp, value;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType te = exp.typecheck(e);
        te = TypeUtils.resolveType(te, e);
        if (te instanceof ASTTRef) {
            ASTType tv = value.typecheck(e);
            tv = TypeUtils.resolveType(tv, e);
            ASTType teGetType = ((ASTTRef)te).getType();
            teGetType = TypeUtils.resolveType(teGetType, e);
            if (tv.equals(teGetType, e)) {
                return tv;
            } else {
                throw new TypeCheckError(":= operator: expected same types in assignment value and inside ref, found "+tv.toStr()+" "+teGetType.toStr());
            }
        } else {
            throw new TypeCheckError(":= operator: type ref expected, found "+te.toStr());
        }
    }

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