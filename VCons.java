class VCons implements IValue {
    IValue head;
    IValue tail;

    VCons(IValue head, IValue tail) {
        this.head = head;
        this.tail = tail;
    }

    IValue getHead() {
        return head;
    }

    IValue getTail() {
        return tail;
    }

    public String toStr() {
        return "cons("+head.toStr()+","+tail.toStr()+")";
    }
}