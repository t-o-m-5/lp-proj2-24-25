public class ASTCons implements ASTNode {
    ASTNode head, tail;

    public IValue eval(Environment<IValue> e) throws InterpreterError {   
        return new VCons(head.eval(e), tail.eval(e));
    }

    public ASTCons(ASTNode head, ASTNode tail) {
        this.head = head;
        this.tail = tail;
    }

}