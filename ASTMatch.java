public class ASTMatch implements ASTNode {
    ASTNode lst, b1, b2;
    String head, tail;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue list = lst.eval(e);
        
        if (list instanceof VNil) {
            return b1.eval(e);
        } else if (list instanceof VCons) {
            Environment<IValue> env = e.beginScope();
            env.assoc(head, ((VCons)list).getHead());
            env.assoc(tail, ((VCons)list).getTail());
            return b2.eval(env);
        } else if (list instanceof VIcons) {
            VIcons icons = ((VIcons)list);
            Environment<IValue> oldEnv = icons.getEnv();
            Environment<IValue> env = e.beginScope();
            env.assoc(head, icons.getHead().eval(oldEnv));
            env.assoc(tail, icons.getTail().eval(oldEnv));
            return b2.eval(env);
        } else {
            throw new InterpreterError("match operator: list expected, found "+list.toStr());
        }
    }

    public ASTMatch(ASTNode lst, ASTNode b1, String head, String tail, ASTNode b2) {
        this.lst = lst;
        this.b1 = b1;
        this.head = head;
        this.tail = tail;
        this.b2 = b2;
    }

}
