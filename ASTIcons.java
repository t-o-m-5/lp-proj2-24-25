public class ASTIcons implements ASTNode {
    ASTNode head, tail;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType th = head.typecheck(e);
        th = TypeUtils.resolveType(th, e);
        ASTType tt = tail.typecheck(e);
        tt = TypeUtils.resolveType(tt, e);
        if (tt instanceof ASTTList) {
            ASTType teElt = ((ASTTList)tt).getElt();
            teElt = TypeUtils.resolveType(teElt, e);
            if (th.equals(teElt, e) || teElt instanceof ASTTAny) {
                return new ASTTList(th);
            } else {
                throw new TypeCheckError(":? operator: expected type inside tail list to be same as head type or type any, found "+teElt.toStr()+" "+th.toStr());
            }
        } else {
            throw new TypeCheckError(":? operator: type list expected in tail, found "+tt.toStr());
        }
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VIcons(head, tail, e);
    }

    public ASTIcons(ASTNode head, ASTNode tail) {
        this.head = head;
        this.tail = tail;
    }

}