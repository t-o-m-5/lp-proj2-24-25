class VClosure implements IValue {
    String arg;
    ASTNode body;
    Environment<IValue> env;

    VClosure(String arg, ASTNode b, Environment<IValue> e) {
        this.arg = arg;
        body = b;
        env = e;
    }

    String getArg() {
        return arg;
    }

    ASTNode getBody() {
        return body;
    }

    Environment<IValue> getEnv() {
        return env;
    }

    public String toStr() {
        return "closure: "+this;
    }
}