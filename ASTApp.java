public class ASTApp implements ASTNode {
    ASTNode func, arg;

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