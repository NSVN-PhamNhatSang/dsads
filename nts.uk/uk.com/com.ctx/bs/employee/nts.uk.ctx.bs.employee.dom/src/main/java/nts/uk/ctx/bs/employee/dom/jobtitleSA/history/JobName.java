package nts.uk.ctx.bs.employee.dom.jobtitleSA.history;

import nts.arc.primitive.StringPrimitiveValue;
import nts.arc.primitive.constraint.StringMaxLength;

/**
 * The Class PositionName.
 */
@StringMaxLength(20)
// 職位名称
public class JobName extends StringPrimitiveValue<JobName> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new position name.
	 *
	 * @param rawValue the raw value
	 */
	public JobName(String rawValue) {
		super(rawValue);
	}

}
