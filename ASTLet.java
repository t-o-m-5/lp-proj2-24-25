import java.util.List;

public class ASTLet implements ASTNode {
    List<Bind> decls;
    ASTNode body;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        Environment<IValue> en = e.beginScope();
        
        for (Bind decl : decls) {
            IValue v = decl.getExp().eval(en);
            en.assoc(decl.getId(), v);
        }
        
        return body.eval(en);
    }

    public ASTLet(List<Bind> decls, ASTNode b) {
        this.decls = decls;
        body = b;
    }

}
