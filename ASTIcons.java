public class ASTIcons implements ASTNode {
    ASTNode head, tail;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VIcons(head, tail, e);
    }

    public ASTIcons(ASTNode head, ASTNode tail) {
        this.head = head;
        this.tail = tail;
    }

}