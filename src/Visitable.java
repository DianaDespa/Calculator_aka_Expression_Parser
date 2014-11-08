/**
 * Interface for objects that can be visited by a visitor.
 * @author Diana
 *
 */
public interface Visitable {
	public void accept(Visitor v);
}
