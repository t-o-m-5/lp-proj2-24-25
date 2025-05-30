public class ASTDiv implements ASTNode {

    ASTNode lhs, rhs;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v1 = lhs.eval(e);
		IValue v2 = rhs.eval(e);

		if (v1 instanceof VInt) {
			if (v2 instanceof VInt) {
				int i1 = ((VInt) v1).getval();
				int i2 = ((VInt) v2).getval();
				if (i2 == 0) throw new InterpreterError("/ operator: division by zero");
				return new VInt(i1 / i2);
			} else {
				throw new InterpreterError("/ operator: integer expected, found "+v2.toStr());
			}
		} else {
			throw new InterpreterError("/ operator: integer expected, found "+v1.toStr());
		}
    }

    public ASTDiv(ASTNode l, ASTNode r) {
		lhs = l;
		rhs = r;
    }

}
