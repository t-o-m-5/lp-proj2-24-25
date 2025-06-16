public class ASTMult implements ASTNode {

    ASTNode lhs, rhs;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType t1 = lhs.typecheck(e);
        t1 = TypeUtils.resolveType(t1, e);
        if (t1 instanceof ASTTInt) {
            ASTType t2 = rhs.typecheck(e);
            t2 = TypeUtils.resolveType(t2, e);
            if (t2 instanceof ASTTInt) {
                return t1;
            } else {
                throw new TypeCheckError("* operator: type int expected, found "+t2.toStr());
            }
        } else {
            throw new TypeCheckError("* operator: type int expected, found "+t1.toStr());
        }
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        
        if (v1 instanceof VInt) {
            if (v2 instanceof VInt) {
                return new VInt(((VInt) v1).getval() * ((VInt) v2).getval());
            } else {
                throw new InterpreterError("* operator: integer expected, found "+v2.toStr());
            }
        } else {
            throw new InterpreterError("* operator: integer expected, found "+v1.toStr());
        }
    }

    public ASTMult(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

}
    

