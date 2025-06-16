public class ASTTArrow implements ASTType {
    
    private ASTType dom;
    private ASTType codom;

    public ASTTArrow(ASTType d, ASTType co) {
        dom = d;
        codom = co;
    }

    public ASTType getDom() {
        return dom;
    }

    public ASTType getCoDom() {
        return codom;
    }

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        if (!(o instanceof ASTTArrow)) return false;
        ASTTArrow oA = (ASTTArrow)o;
        return dom.equals(oA.getDom(), e) && codom.equals(oA.getCoDom(), e);
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        if (o instanceof ASTTAny) return true;
        if (!(o instanceof ASTTArrow)) return false;
        ASTTArrow oA = (ASTTArrow)o;
        return oA.getDom().isSubtypeOf(dom, e) && codom.isSubtypeOf(oA.getCoDom(), e);
    }

    public String toStr() {
        return dom.toStr()+"->"+codom.toStr();
    }

}
