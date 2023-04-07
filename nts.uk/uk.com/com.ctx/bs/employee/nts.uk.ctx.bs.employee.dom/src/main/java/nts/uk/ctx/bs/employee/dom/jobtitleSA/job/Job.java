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
	private int jobInforId;
	private boolean isAbolition;
	private JobCode jobCode;
	private List<JobHistory> jobHistories;
	
	public Job(int jobInforId, boolean isAbolition, JobCode jobCode) {
		super();
		this.jobInforId = jobInforId;
		this.isAbolition = isAbolition;
		this.jobCode = jobCode;
	}
	
	public JobHistory getLastestHistory() {
		final int indexLastestHistory = 0;
        return this.jobHistories.get(indexLastestHistory);
	}
}

