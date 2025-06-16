public class TypeUtils {
    public static ASTType resolveType(ASTType t, Environment<ASTType> e) throws InterpreterError {
        while (t instanceof ASTTId) {
            t = e.find(((ASTTId)t).getId());
        }
        return t;
    }
}