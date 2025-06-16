public class ASTNot implements ASTNode {

    ASTNode exp;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
      ASTType t = exp.typecheck(e);
      t = TypeUtils.resolveType(t, e);
      if (t instanceof ASTTBool) {
        return t;
      } else {
			  throw new TypeCheckError("~ operator: type bool expected, found "+t.toStr());
		  }
    }

    public IValue eval(Environment <IValue>e) throws InterpreterError { 
      IValue v1 = exp.eval(e);
      
      if (v1 instanceof VBool) {
              return ((VBool)v1).getval() == true ? new VBool(false) : new VBool(true);
      } else { 
        throw new InterpreterError("~ operator: boolean expected, found "+v1.toStr()); 
      }
    }
        
    public ASTNot(ASTNode e) {
		  exp = e;
    }

}
