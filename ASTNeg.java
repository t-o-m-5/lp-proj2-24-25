public class ASTNeg implements ASTNode {

    ASTNode exp;

    public IValue eval(Environment<IValue> e) throws InterpreterError { 
		IValue v1 = exp.eval(e);
		
		if (v1 instanceof VInt) { 
			return new VInt(-((VInt)v1).getval()); 
		} else { 
			throw new InterpreterError("- operator: integer expected, found "+v1.toStr()); 
		}
    }
        
    public ASTNeg(ASTNode e) {
		exp = e;
    }

}

