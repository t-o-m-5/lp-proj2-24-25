public class ASTEq implements ASTNode {

    ASTNode lhs, rhs;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType t1 = lhs.typecheck(e);
        t1 = TypeUtils.resolveType(t1, e);
        ASTType t2 = rhs.typecheck(e);
        t2 = TypeUtils.resolveType(t2, e);
        if ((t1 instanceof ASTTBool && t2 instanceof ASTTBool) || (t1 instanceof ASTTInt && t2 instanceof ASTTInt)) {
            return new ASTTBool();
        } else {
            throw new TypeCheckError("== operator: two types bool or two types int expected, found "+t1.toStr()+" "+t2.toStr());
        }
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError { 
		IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);

		if (v1 instanceof VInt && v2 instanceof VInt) { 
			return new VBool(((VInt)v1).getval() == ((VInt)v2).getval()); 
		} else if (v1 instanceof VBool && v2 instanceof VBool) {
            return new VBool(((VBool)v1).getval() == ((VBool)v2).getval()); 
        } else {
			throw new InterpreterError("== operator: expected two integers or two booleans, found "+v1.toStr()+" "+v2.toStr());  
		}
    }
        
    public ASTEq(ASTNode l, ASTNode r) {
		lhs = l;
        rhs = r;
    }
}
