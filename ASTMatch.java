public class ASTMatch implements ASTNode {
    ASTNode lst, b1, b2;
    String head, tail;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType tl = lst.typecheck(e);
        tl = TypeUtils.resolveType(tl, e);
        ASTType tb1 = b1.typecheck(e);
        tb1 = TypeUtils.resolveType(tb1, e);
        if (tl instanceof ASTTList) {
            ASTType tlElt = ((ASTTList)tl).getElt();
            tlElt = TypeUtils.resolveType(tlElt, e);
            Environment<ASTType> en = e.beginScope();
            en.assoc(head, tlElt);
            en.assoc(tail, tl);
            ASTType tb2 = b2.typecheck(en);
            tb2 = TypeUtils.resolveType(tb2, e);
            if (tb1.equals(tb2, en)) {
                return tb1;
            } else {
                throw new TypeCheckError("match operator: expected same types on both branches, found "+tb1.toStr()+" "+tb2.toStr());
            }
        } else {
            throw new TypeCheckError("match operator: type list expected, found "+tl.toStr());
        }
    }

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
