/**
 * EvaluatorException class defines the mathematical incompatibilities that
 * might appear during the evaluation of an expression.
 * 
 * @author Diana
 *
 */
public class EvaluatorException extends RuntimeException {

	private static final long serialVersionUID = 5729607299984502799L;

	public static String NEG_SQRT = "negative value passed to square root";
	public static String NEG_LOG = "negative value passed to logarithm";
	public static String ZERO_LOG = "expression under logarithm evaluates to zero";
	public static String ZERO_DIV = "division by zero";
		
	public EvaluatorException() {}
	
	public EvaluatorException(String str) {
		super(str);
	}
}
