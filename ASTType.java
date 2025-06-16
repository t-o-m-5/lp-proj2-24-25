public interface ASTType  {
    String toStr();
    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError;
    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError;

}


