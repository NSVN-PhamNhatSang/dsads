package nts.uk.ctx.bs.employee.dom.jobtitleSA.history;

import nts.arc.time.GeneralDate;

public interface JobHistoryRepository {
	void addHistory(JobHistory jobhistory);

	/**
	 * Update history.
	 *
	 * @param companyId the company id
	 * @param historyId the history id
	 * @param endĐate the end date
	 */
	void updateHistory(String historyId, GeneralDate endDate);
	
	/**
	 * Update lastest history.
	 *
	 * @param companyId the company id
	 * @param jobTitleId the job title id
	 * @param endĐate the end date
	 */
	void updateLastestHistory(String jobInforId, GeneralDate endDate);
}
