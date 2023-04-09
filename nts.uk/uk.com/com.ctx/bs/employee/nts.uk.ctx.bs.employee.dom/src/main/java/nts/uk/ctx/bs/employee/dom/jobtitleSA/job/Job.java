package nts.uk.ctx.bs.employee.dom.jobtitleSA.job;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import nts.arc.layer.dom.AggregateRoot;
import nts.uk.ctx.bs.employee.dom.jobtitle.history.JobTitleHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;

@Getter
@Setter
public class Job  extends AggregateRoot{
	private boolean isAbolition;
	private JobCode jobCode;
	private String jobInforId;
	
	public Job(String jobInforId, boolean isAbolition, JobCode jobCode) {
		super();
		this.jobInforId=jobInforId;
		this.isAbolition = isAbolition;
		this.jobCode = jobCode;
		
	}
	
}

