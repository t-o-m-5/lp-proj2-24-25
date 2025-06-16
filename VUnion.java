class VUnion implements IValue {
    IValue value;

    VUnion(IValue value) {
        this.value = value;
    }

    IValue getValue() {
        return value;
    }

    public String toStr() {
        return value.toStr();
    }

}