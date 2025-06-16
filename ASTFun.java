public class ASTFun implements ASTNode {
    String arg;
    ASTNode body;
    ASTType argType;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        Environment<ASTType> en = e.beginScope();
        en.assoc(arg, argType);
        ASTType tb = body.typecheck(en);
        tb = TypeUtils.resolveType(tb, e);
        return new ASTTArrow(argType, tb);
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VClosure(arg, body, e);
    }

    public ASTFun(String arg, ASTNode body, ASTType argType) {
        this.arg = arg;
        this.body = body;
        this.argType = argType;
    }

    public void setBody(ASTNode body) {
        this.body = body;
    }

}