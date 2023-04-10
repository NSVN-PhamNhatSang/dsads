package nts.uk.ctx.bs.employee.dom.jobtitleSA.history;

import java.util.List;

import nts.arc.time.GeneralDate;

public interface JobHistoryRepository {
	void addHistory(JobHistory jobhistory);

	/**
	 * Update history.
	 *
	 * @param companyId the company id
	 * @param historyId the history id
	 * @param endÄ�ate the end date
	 */
	void updateHistory(JobHistory jobHistory);
	
	/**
	 * Update lastest history.
	 *
	 * @param companyId the company id
	 * @param jobTitleId the job title id
	 * @param endÄ�ate the end date
	 */
	
	List<JobHistory> findInDate(GeneralDate date);
	
	List<JobHistory> findByJobId(String jobInfor);
	
	List<JobHistory> findByJobCode(String jobCode);
	
	void removeHis(JobHistory jobHistory);
	
	
	
}
