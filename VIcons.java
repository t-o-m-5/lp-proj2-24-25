class VIcons implements IValue {
    ASTNode head;
    ASTNode tail;
    Environment<IValue> env;

    VIcons(ASTNode head, ASTNode tail, Environment<IValue> env) {
        this.head = head;
        this.tail = tail;
        this.env = env;
    }

    ASTNode getHead() {
        return head;
    }

    ASTNode getTail() {
        return tail;
    }

    Environment<IValue> getEnv() {
        return env;
    }

    public String toStr() {
        return "icons("+head+","+tail+")";
    }
}