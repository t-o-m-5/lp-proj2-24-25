import java.util.*;

class VStruct implements IValue {
    HashMap<String, IValue> fields;

    VStruct(HashMap<String, IValue> fields) {
        this.fields = fields;
    }

    HashMap<String, IValue> getFields() {
        return fields;
    }

    public String toStr() {
        return fields.toString();
    }

}
