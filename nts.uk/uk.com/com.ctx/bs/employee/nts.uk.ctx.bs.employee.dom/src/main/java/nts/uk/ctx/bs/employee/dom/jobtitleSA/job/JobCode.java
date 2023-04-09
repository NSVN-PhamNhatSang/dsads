package nts.uk.ctx.bs.employee.dom.jobtitleSA.job;

import nts.arc.primitive.constraint.CharType;
import nts.arc.primitive.constraint.StringCharType;
import nts.arc.primitive.constraint.StringMaxLength;
import nts.uk.shr.com.primitive.CodePrimitiveValue;
import nts.uk.shr.com.primitive.ZeroPaddedCode;

/**
 * The Class PositionCode.
 */
@StringCharType(CharType.ALPHA_NUMERIC)
@StringMaxLength(5)
@ZeroPaddedCode
public class JobCode extends CodePrimitiveValue<JobCode> {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Instantiates a new position code.
		 *
		 * @param rawValue the raw value
		 */
		public JobCode(String rawValue) {
			super(rawValue);
		}

}
