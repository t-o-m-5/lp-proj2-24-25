public class ASTWhile implements ASTNode {
    ASTNode cond, body;

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType tc = cond.typecheck(e);
        tc = TypeUtils.resolveType(tc, e);
        if (tc instanceof ASTTBool) {
            return body.typecheck(e);
        } else {
            throw new TypeCheckError("while operator: type bool expected in condition, found "+tc.toStr());
        }
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue res = new VBool(false), c = cond.eval(e);
        while (true) {
            if (c instanceof VBool) {
                if (((VBool)c).getval()) {
                    res = body.eval(e);
                    c = cond.eval(e);
                } else {
                    return res;
                }
            } else {
                throw new InterpreterError("while operator: boolean expected, found "+c.toStr());
            }
        }
    }

    public ASTWhile(ASTNode cond, ASTNode b) {
        this.cond = cond;
        body = b;
    }

}
