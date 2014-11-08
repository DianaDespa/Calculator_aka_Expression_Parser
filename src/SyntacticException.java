/**
 * SyntacticException class defines the syntactic mistakes that might appear in
 * an expression.
 * 
 * @author Diana
 *
 */
public class SyntacticException extends Exception {

	private static final long serialVersionUID = 2916684190445948659L;
	
	public static String INV_OP = "invalid operator";
	public static String CONS_BIN = "consecutive binary operators";
	public static String AFT_BIN = "binary operator after unary operator";
	public static String CONS_OPD = "consecutive operands";
	public static String NUM_BRACK = "invalid number of brackets";
	
	public SyntacticException() {}
	
	public SyntacticException(String str) {
		super(str);
	}
}
