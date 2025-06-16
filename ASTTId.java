public	class ASTTId implements ASTType	{	

    String id;	
    
    public ASTTId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean equals(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        ASTType idType = e.find(id);
        return idType.equals(o, e);
    }

    public boolean isSubtypeOf(ASTType o, Environment<ASTType> e) throws InterpreterError {
        o = TypeUtils.resolveType(o, e);
        if (o instanceof ASTTAny) return true;
        ASTType idType = e.find(id);
        return idType.isSubtypeOf(o, e);
    }
    
    public String toStr() {
        return id;
    }

}	
