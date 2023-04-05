package nts.uk.ctx.sys.portal.dom.webmenu;

import nts.arc.primitive.StringPrimitiveValue;
import nts.arc.primitive.constraint.StringMaxLength;

/**
 * 
 * @author sonnh
 *
 */
@StringMaxLength(20)
public class WebMenuName extends StringPrimitiveValue<WebMenuName> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebMenuName(String rawValue) {
		super(rawValue);
		// TODO Auto-generated constructor stub
	}

}
