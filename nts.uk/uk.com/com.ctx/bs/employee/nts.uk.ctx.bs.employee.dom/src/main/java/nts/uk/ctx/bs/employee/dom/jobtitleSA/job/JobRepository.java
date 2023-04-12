package nts.uk.ctx.bs.employee.dom.jobtitleSA.job;

import java.util.List;
import java.util.Optional;

import nts.arc.time.GeneralDate;


public interface JobRepository {
	/**
	 * Adds the.
	 *
	 * @param jobTitle the job title
	 */
	void addJob(Job job);

	/**
	 * Update.
	 *
	 * @param jobTitle the job title
	 */
	void updateJob(Job job);


	 /**
     * Find by job title id.
     *
     * @param companyId the company id
     * @param jobTitleId the job title id
     * @return the optional
     */
	List<Job> findByDate(GeneralDate today);
	
    Optional<Job> findByJobInforId( String jobInforId);
    
    /**
     * Find by history id.
     *
     * @param companyId the company id
     * @param historyId the history id
     * @return the optional
     */
    Optional<Job> findByHistoryId( String historyId);
    
}
