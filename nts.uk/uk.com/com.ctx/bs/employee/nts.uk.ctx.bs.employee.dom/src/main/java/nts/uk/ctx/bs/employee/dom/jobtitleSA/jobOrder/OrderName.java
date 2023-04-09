package nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder;

import nts.arc.primitive.constraint.CharType;
import nts.arc.primitive.constraint.StringCharType;
import nts.arc.primitive.constraint.StringMaxLength;
import nts.uk.shr.com.primitive.CodePrimitiveValue;
@StringCharType(CharType.ALPHA_NUMERIC)
@StringMaxLength(20)
public class OrderName extends CodePrimitiveValue<OrderName>{
	private static final long serialVersionUID = 1L;
	
	public OrderName(String rawValue){
		super(rawValue);
	}
}
