public class ASTFun implements ASTNode {
    String arg;
    ASTNode body;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VClosure(arg, body, e);
    }

    public ASTFun(String arg, ASTNode body) {
        this.arg = arg;
        this.body = body;
    }

}