public class ASTNil implements ASTNode {

    public IValue eval(Environment<IValue> e) {
        return new VNil();
    }

    ASTNil() {}
}