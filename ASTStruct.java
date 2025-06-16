import java.util.*;

public class ASTStruct implements ASTNode {

    private Map<String, ASTNode> fields;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        HashMap<String,ASTType> tbl = new HashMap<String,ASTType>();
        for (Map.Entry<String, ASTNode> entry : fields.entrySet()) {
            tbl.put(entry.getKey(), entry.getValue().typecheck(e));
        }
        return new ASTTStruct(new TypeBindList(tbl));
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        HashMap<String, IValue> fieldsEval = new HashMap<String, IValue>();
        for (Map.Entry<String, ASTNode> entry : fields.entrySet()) {
            fieldsEval.put(entry.getKey(), entry.getValue().eval(e));
        }
        return new VStruct(fieldsEval);
    }

    public ASTStruct(Map<String, ASTNode> fields) {
        this.fields = fields;
    }

}
