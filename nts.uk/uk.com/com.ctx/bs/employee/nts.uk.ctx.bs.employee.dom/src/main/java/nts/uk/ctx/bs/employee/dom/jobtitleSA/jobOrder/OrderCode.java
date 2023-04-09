package nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder;

import nts.arc.primitive.constraint.CharType;
import nts.arc.primitive.constraint.StringCharType;
import nts.arc.primitive.constraint.StringMaxLength;

import nts.uk.shr.com.primitive.CodePrimitiveValue;
import nts.uk.shr.com.primitive.ZeroPaddedCode;
@StringCharType(CharType.ALPHA_NUMERIC)
@StringMaxLength(2)
@ZeroPaddedCode
public class OrderCode extends CodePrimitiveValue<OrderCode> {
	private static final long serialVersionUID = 1L;
	
	public OrderCode(String rawValue){
		  super(rawValue);
	}
}
