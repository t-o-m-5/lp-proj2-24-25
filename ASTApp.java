public class ASTApp implements ASTNode {
    ASTNode func, arg;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType tf = func.typecheck(e);
        tf = TypeUtils.resolveType(tf, e);
        if (tf instanceof ASTTArrow) {
            ASTType ta = arg.typecheck(e);
            ta = TypeUtils.resolveType(ta, e);
            ASTType tdom = ((ASTTArrow)tf).getDom();
            tdom = TypeUtils.resolveType(tdom, e);
            ASTType tcodom = ((ASTTArrow)tf).getCoDom();
            tcodom = TypeUtils.resolveType(tcodom, e);
            if (ta.isSubtypeOf(tdom, e)) {
                return tcodom;
            } else {
                throw new TypeCheckError("function application: a subtype of "+tdom.toStr()+" expected as argument type, found "+ta.toStr());
            }
        } else {
            throw new TypeCheckError("function application: type arrow expected as function type, found "+tf.toStr());
        }
    }
    
    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue clos = func.eval(e);

        if (clos instanceof VClosure) {
            VClosure closure = (VClosure)clos;
            Environment<IValue> env = closure.getEnv().beginScope();
            env.assoc(closure.getArg(), arg.eval(e));
            return (closure.getBody().eval(env));
        } else {
            throw new InterpreterError("function application: closure expected, found "+clos.toStr());
        }
    }

    public ASTApp(ASTNode func, ASTNode arg) {
        this.func = func;
        this.arg = arg;
    }

}