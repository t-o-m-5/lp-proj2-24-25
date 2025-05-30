public class ASTOr implements ASTNode {

    ASTNode lhs, rhs;

    public IValue eval(Environment<IValue> e) throws InterpreterError { 
		IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);

		if (v1 instanceof VBool) {
            if (v2 instanceof VBool) {
                return new VBool(((VBool)v1).getval() || ((VBool)v2).getval()); 
            } else {
                throw new InterpreterError("|| operator: boolean expected, found "+v2.toStr());
            }
        } else {
			throw new InterpreterError("|| operator: boolean expected, found "+v1.toStr());
		}
    }
        
    public ASTOr(ASTNode l, ASTNode r) {
		lhs = l;
        rhs = r;
    }
}
