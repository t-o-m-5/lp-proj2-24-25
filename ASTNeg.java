public class ASTNeg implements ASTNode {

    ASTNode exp;

	  public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
      ASTType t = exp.typecheck(e);
      t = TypeUtils.resolveType(t, e);
      if (t instanceof ASTTInt) {
        return t;
      } else {
			  throw new TypeCheckError("- operator: type int expected, found "+t.toStr());
		  }
    }

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

