public class ASTNot implements ASTNode {

    ASTNode exp;

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
