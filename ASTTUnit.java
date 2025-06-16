class ASTTUnit implements ASTType {
        
    public ASTTUnit() {
    }

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return o instanceof ASTTUnit;
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return (o instanceof ASTTAny) ? true : o instanceof ASTTUnit;
    }

    public String toStr() {
        return "()";
    }

}