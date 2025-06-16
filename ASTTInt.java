public class ASTTInt implements ASTType {
    
    public ASTTInt() {
    }
    
    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return o instanceof ASTTInt;
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return (o instanceof ASTTAny) ? true : o instanceof ASTTInt;
    }

    public String toStr() {
        return "int";
    }

}


