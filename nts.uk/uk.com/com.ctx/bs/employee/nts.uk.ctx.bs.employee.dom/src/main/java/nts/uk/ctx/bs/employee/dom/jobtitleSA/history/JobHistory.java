package nts.uk.ctx.bs.employee.dom.jobtitleSA.history;

import nts.arc.layer.dom.AggregateRoot;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;
import lombok.Getter;

@Getter

public class JobHistory extends AggregateRoot {	
	private String historyId;
	private JobCode jobCode;
	private JobName jobName;
	private OrderCode orderCode;
	private boolean isManager;
	private GeneralDate startDate;
	private GeneralDate endDate;
	
	public JobHistory(String historyId, JobCode jobCode, JobName jobName, OrderCode orderCode, boolean isManager,
			GeneralDate startDate, GeneralDate endDate) {
		super();
		this.historyId = historyId;
		this.jobCode = jobCode;
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
	public void updateStartDate(GeneralDate newStartDate) {
		
	}
	
	/**
	 * Update end date.
	 *
	 * @param newEndDate the new end date
	 */
	public void updateEndDate(GeneralDate newEndDate) {

	}
}

