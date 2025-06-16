public class ASTTAny implements ASTType {
        
    public ASTTAny() {
    }

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return o instanceof ASTTAny;
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return o instanceof ASTTAny;
    }

    public String toStr() {
        return "any";
    }

}