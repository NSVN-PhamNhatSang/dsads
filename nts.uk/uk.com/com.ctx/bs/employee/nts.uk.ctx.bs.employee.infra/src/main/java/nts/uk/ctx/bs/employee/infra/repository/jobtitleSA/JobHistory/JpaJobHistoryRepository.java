package nts.uk.ctx.bs.employee.infra.repository.jobtitleSA.JobHistory;

import java.util.ArrayList;
import java.util.List;

import nts.arc.layer.infra.data.JpaRepository;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitle.main.JobTitleMain;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistoryRepository;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobName;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;
import nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.JobHistory.JobHistoryTable;

public class JpaJobHistoryRepository extends JpaRepository implements JobHistoryRepository{
    
	
	
	private static final String SELECT_NO_WHERE = "SELECT j.historyId,h.jobCode, j.JobName,j.orderCode,j.isManager,j.startDate,j.endDate FROM JobHistoryTable j ";
			//+ " INNER JOIN BsymtJobPosMainHist h ON h.histId = j.histId";
	
	private static final String SELECT_JOB_TITLE_MAIN_BY_ID = SELECT_NO_WHERE
			+ " WHERE j.jobTitleId = :jobTitleId";

	private static final String SELECT_BY_DATE = SELECT_NO_WHERE
			+ ", JobTable h WHERE j.startDate <= :date And j.endDate >= :date And j.jobinforId=h.jobId";
	
	private static final String GET_ALL_BY_JOBID = SELECT_NO_WHERE
			+ ", JobTable h WHERE h.jobId = :jobId And j.jobinforId=h.jobId ";
	
	private JobHistory toDomain(Object[] entity) {
		return new JobHistory(String.valueOf(entity[0].toString()), new JobCode(String.valueOf(entity[1].toString())), 
				new JobName(String.valueOf(entity[2].toString())),new OrderCode(String.valueOf(entity[3].toString())),(boolean)entity[4],
				GeneralDate.fromString(entity[5].toString(), "yyyy-MM-dd"), GeneralDate.fromString(entity[6].toString(), "yyyy-MM-dd"));
	}
	
	private List<JobHistory> toListJobHistory(List<Object[]> listEntity) {
		List<JobHistory> lstJobHistory = new ArrayList<>();
		if (!listEntity.isEmpty()) {
			listEntity.stream().forEach(c -> {
				JobHistory jobHistory = toDomain(c);
				
				lstJobHistory.add(jobHistory);
			});
		}
		return lstJobHistory;
	}
	
	private JobHistoryTable toEntity(JobHistory jobHistory){
		    JobHistoryTable entity= this.queryProxy()
		    		.find(jobHistory.getHistoryId(),JobHistoryTable.class)
		    		.orElse(new JobHistoryTable());
		    entity.setHistoryId(jobHistory.getHistoryId());
		    entity.setJobCode(jobHistory.getJobCode());
		    entity.setJobName(jobHistory.getJobName());
		    entity.setOrderCode(jobHistory.getOrderCode());
		    entity.setIsManager(new Boolean(jobHistory.isManager()));
		    entity.setStartDate(jobHistory.getStartDate());
		    entity.setEndDate(jobHistory.getEndDate());
		    return entity;
	}
	
	@Override
	public void addHistory(JobHistory jobHistory) {
		   this.commandProxy().insert(this.toEntity(jobHistory));
		
	}

	@Override
	public void updateHistory(JobHistory jobHistory) {
		   this.commandProxy().update(this.toEntity(jobHistory));
		
	}


	@Override
	public List<JobHistory> findInDate(GeneralDate date) {
		List<Object[]> listEntity=this.queryProxy().query(SELECT_BY_DATE,Object[].class)
				                                   .setParameter("date", date)
		                                           .getList();
		
		return toListJobHistory(listEntity);
	}

	@Override
	public List<JobHistory> findByJobCode(String jobinforId) {
		
		List<Object[]> listEntity=this.queryProxy().query(GET_ALL_BY_JOBID,Object[].class)
				                                    .setParameter(":jobId", jobinforId)
				                                    .getList();
		return toListJobHistory(listEntity);
	}

}
