public class ASTTStruct implements ASTType {

    private TypeBindList ll;

    public ASTTStruct(TypeBindList llp) {
        ll = llp;
    }

    public TypeBindList getLl() {
        return ll;
    }

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        /*  TO DO */
        return false;
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        if (o instanceof ASTTAny) return true;
        /*  TO DO */
        return false;
    }

    public String toStr() {
        return "struct { ... }";
    }

}