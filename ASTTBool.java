class ASTTBool implements ASTType {
        
    public ASTTBool() {
    }

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return o instanceof ASTTBool;
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return (o instanceof ASTTAny) ? true : o instanceof ASTTBool;
    }

    public String toStr() {
        return "bool";
    }

}