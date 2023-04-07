package nts.uk.ctx.bs.employee.dom.jobtitleSA.job;

import java.util.Optional;


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
    Optional<Job> findByJobTitleId( String jobTitleId);
    
    /**
     * Find by history id.
     *
     * @param companyId the company id
     * @param historyId the history id
     * @return the optional
     */
    Optional<Job> findByHistoryId( String historyId);
    
}
