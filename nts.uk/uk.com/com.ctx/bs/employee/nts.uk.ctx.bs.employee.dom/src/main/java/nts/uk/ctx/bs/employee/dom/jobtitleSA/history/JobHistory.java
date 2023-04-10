package nts.uk.ctx.bs.employee.dom.jobtitleSA.history;

import nts.arc.layer.dom.AggregateRoot;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobHistory extends AggregateRoot implements Comparable<JobHistory>{	
	private String historyId;
	private String jobId;
	private JobName jobName;
	private OrderCode orderCode;
	private boolean isManager;
	private GeneralDate startDate;
	private GeneralDate endDate;
	
	public JobHistory(String historyId, String jobId, JobName jobName, OrderCode orderCode, boolean isManager,
			GeneralDate startDate, GeneralDate endDate) {
		super();
		this.historyId = historyId;
		this.jobId = jobId;
		this.jobName = jobName;
		this.orderCode = orderCode;
		this.isManager = isManager;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	

	/**
	 * Update start date.
	 *
	 * @param newStartDate the new start date
	 */
	public GeneralDate updateStartDate(GeneralDate newStartDate) {
		   
		   this.startDate=newStartDate;
		   
		   return newStartDate.nextValue(false);
	}
	
	/**
	 * Update end date.
	 *
	 * @param newEndDate the new end date
	 */
	public void addStartDate(GeneralDate newEndDate) {
           
	}


	@Override
	public int compareTo(JobHistory jobHis) {
		return this.startDate.compareTo(jobHis.getStartDate());
	}
}

