public class ASTFieldSelect implements ASTNode {
    ASTNode node;
    String label;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        /* TO DO */
        return null;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        /* TO DO */
        return null;
    }

    public ASTFieldSelect(ASTNode node, String label) {
        this.node = node;
        this.label = label;
    }
}
