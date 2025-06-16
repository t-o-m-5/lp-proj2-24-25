public class ASTNil implements ASTNode {

    public ASTType typecheck(Environment<ASTType> e) {
        return new ASTTList(new ASTTAny());
    }

    public IValue eval(Environment<IValue> e) {
        return new VNil();
    }

    ASTNil() {}
}