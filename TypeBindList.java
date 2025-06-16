import java.util.*;

public class TypeBindList  {

        private HashMap<String,ASTType> lbl;

        public TypeBindList(HashMap<String,ASTType> ll) {
                lbl = ll;
        }

        public HashMap<String,ASTType> getLbl() {
                return lbl;
        }
}