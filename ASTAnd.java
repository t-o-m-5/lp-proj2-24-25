public class ASTAnd implements ASTNode {

    ASTNode lhs, rhs;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType t1 = lhs.typecheck(e);
        t1 = TypeUtils.resolveType(t1, e);
        if (t1 instanceof ASTTBool) {
            ASTType t2 = rhs.typecheck(e);
            t2 = TypeUtils.resolveType(t2, e);
            if (t2 instanceof ASTTBool) {
                return new ASTTBool();
            } else {
                throw new TypeCheckError("&& operator: type bool expected, found "+t2.toStr());
            }
        } else {
            throw new TypeCheckError("&& operator: type bool expected, found "+t1.toStr());
        }
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError { 
		IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);

		if (v1 instanceof VBool) {
            if (v2 instanceof VBool) {
                return new VBool(((VBool)v1).getval() && ((VBool)v2).getval()); 
            } else {
                throw new InterpreterError("&& operator: boolean expected, found "+v2.toStr());
            }
        } else {
			throw new InterpreterError("&& operator: boolean expected, found "+v1.toStr());
		}
    }

    public ASTAnd(ASTNode l, ASTNode r) {
		lhs = l;
        rhs = r;
    }
}
