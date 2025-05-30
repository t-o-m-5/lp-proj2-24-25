public class ASTLteq implements ASTNode {

    ASTNode lhs, rhs;

    public IValue eval(Environment<IValue> e) throws InterpreterError { 
		    IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);

        if (v1 instanceof VInt) {
          if (v2 instanceof VInt) {
            return new VBool(((VInt)v1).getval() <= ((VInt)v2).getval()); 
          } else {
            throw new InterpreterError("<= operator: integer expected, found "+v2.toStr());
          }
        } else {
          throw new InterpreterError("<= operator: integer expected, found "+v1.toStr()); 
        }
    }

    public ASTLteq(ASTNode l, ASTNode r) {
		    lhs = l;
        rhs = r;
    }
}
