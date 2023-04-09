package nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nts.arc.layer.dom.AggregateRoot;
import nts.uk.ctx.bs.employee.dom.common.CompanyId;
import nts.uk.ctx.bs.employee.dom.jobtitle.history.JobTitleHistory;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobOrder extends AggregateRoot{
	
	private OrderCode orderCode;
    
	private OrderName orderName;
	
	private int index;
     
}
