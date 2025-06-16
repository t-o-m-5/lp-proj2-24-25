import java.util.*;

public class ASTTypeDef implements ASTNode {
    HashMap<String,ASTType> ltd;
    ASTNode body;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        Environment<ASTType> en = e.beginScope();
        for (Map.Entry<String,ASTType> entry : ltd.entrySet()) {
            en.assoc(entry.getKey(), entry.getValue());
        }
        return body.typecheck(en);
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        return body.eval(env);
    }

    public ASTTypeDef(HashMap<String,ASTType> ltdp, ASTNode b) {
	    ltd = ltdp;
        body = b;
    }

}
