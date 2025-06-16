public class ASTTRef implements ASTType {

    private ASTType type;

    public ASTTRef(ASTType type) {
        this.type = type;
    }
    
    public ASTType getType() {
        return type;
    }

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        if (!(o instanceof ASTTRef)) return false;
        ASTType oType = ((ASTTRef)o).getType();
        return type.equals(oType, e);
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        if (o instanceof ASTTAny) return true;
        if (!(o instanceof ASTTRef)) return false;
        ASTType oRType = ((ASTTRef)o).getType();
        return type.isSubtypeOf(oRType, e) && oRType.isSubtypeOf(type, e);
    }

    public String toStr() {
        return "ref<"+type.toStr()+">";
    }

}