import java.util.List;

public class ASTLet implements ASTNode {
    List<Bind> decls;
    ASTNode body;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        Environment<ASTType> en = e.beginScope();
        for (Bind decl : decls) {
            ASTType tdecl = decl.getType();
            tdecl = TypeUtils.resolveType(tdecl, e);
            if (tdecl == null) {
                ASTType texp = decl.getExp().typecheck(en);
                texp = TypeUtils.resolveType(texp, e);
                en.assoc(decl.getId(), texp);
            } else {
                en.assoc(decl.getId(), tdecl);
                ASTType texp = decl.getExp().typecheck(en);
                texp = TypeUtils.resolveType(texp, e);
                if (!texp.equals(tdecl, en)) {
                    throw new TypeCheckError("let operator: declared type and actual type of expression must be the same, found "+tdecl.toStr()+" "+texp.toStr());
                }
            }
        }
        return body.typecheck(en);
    }

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
