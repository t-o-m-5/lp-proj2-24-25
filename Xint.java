public class Xint {

    public static void main(String args[]) {
		Parser parser = new Parser(System.in);
		ASTNode exp;
		
		System.out.println("X++ interpreter PL MEIC 2024/25 (v0.0)\n");

		while (true) {
			try {
				System.out.print("# ");
				exp = parser.Start();
				if (exp==null) System.exit(0);
				Environment<ASTType> tenv = new Environment<ASTType>();
				exp.typecheck(tenv);
				IValue v = exp.eval(new Environment<IValue>());
				System.out.println(v.toStr());
			} catch (ParseException e) {
				System.out.println("Syntax Error.");
				parser.ReInit(System.in);
			} catch (TypeCheckError e) {
				System.out.println("Type Error: " + e.getMessage());
				parser.ReInit(System.in);
			} catch (Exception e) {
				e.printStackTrace();
				parser.ReInit(System.in);
			}
		}
    }
    
}
