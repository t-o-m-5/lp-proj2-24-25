public class ASTTString implements ASTType {

    public ASTTString() {}

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return o instanceof ASTTString;
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        return (o instanceof ASTTAny) ? true : o instanceof ASTTString;
    }

    public String toStr() {
        return "string";
    }

}
