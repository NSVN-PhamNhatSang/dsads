package nts.uk.ctx.bs.employee.dom.jobtitleSA.history;

import nts.arc.layer.dom.AggregateRoot;
import nts.arc.time.GeneralDate;
import lombok.Getter;

@Getter

public class JobHistory extends AggregateRoot {	
	private int historyId;
	private int jobHistoryId;
	private String jobName;
	private int orderCode;
	private boolean isManager;
	private GeneralDate startDate;
	private GeneralDate endDate;
	
	public JobHistory(int historyId, int jobHistoryId, String jobName, int orderCode, boolean isManager,
			GeneralDate startDate, GeneralDate endDate) {
		super();
		this.historyId = historyId;
		this.jobHistoryId = jobHistoryId;
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

