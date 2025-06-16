public class ASTTList implements ASTType {
    
    private ASTType elt;

    public ASTTList(ASTType eltt) {
        elt = eltt;
    }

    public ASTType getElt() {
        return elt;
    }

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        if (!(o instanceof ASTTList)) return false;
        ASTTList oL = (ASTTList)o;
        return elt.equals(oL.getElt(), e);
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        if (o instanceof ASTTAny) return true;
        if (!(o instanceof ASTTList)) return false;
        ASTTList oL = (ASTTList)o;
        return elt.isSubtypeOf(oL.getElt(), e);
    }

    public String toStr() {
        return "list<"+elt.toStr()+">";
    }

}
