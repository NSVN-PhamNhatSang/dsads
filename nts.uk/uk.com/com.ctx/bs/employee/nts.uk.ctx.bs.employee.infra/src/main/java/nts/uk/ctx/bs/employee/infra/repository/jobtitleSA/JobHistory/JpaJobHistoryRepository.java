package nts.uk.ctx.bs.employee.infra.repository.jobtitleSA.JobHistory;

import java.util.ArrayList;
import java.util.Collections;
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
    
	
	
	private static final String SELECT_NO_WHERE = "SELECT j.historyId,h.jobId, j.JobName,j.orderCode,j.isManager,j.startDate,j.endDate FROM JobHistoryTable j ";
			//+ " INNER JOIN BsymtJobPosMainHist h ON h.histId = j.histId";
	
	private static final String SELECT_JOB_TITLE_MAIN_BY_ID = SELECT_NO_WHERE
			+ " WHERE j.jobTitleId = :jobTitleId";

	private static final String SELECT_BY_DATE = SELECT_NO_WHERE
			+ ", JobTable h WHERE j.startDate <= :date And j.endDate >= :date And j.jobId=h.jobId";
	
	private static final String GET_ALL_BY_JOBID = SELECT_NO_WHERE
			+ ", JobTable h WHERE h.jobId = :jobId And j.jobiId=h.jobId ";
	private static final String GET_ALL_BY_JOBCODE =SELECT_NO_WHERE
			+ ", JobTable h WHERE h.jobId = :jobId And h.jobCode= :jobCode ";
	private JobHistory toDomain(JobHistoryTable entity) {
		return new JobHistory(entity.getHistoryId(),entity.getJobId(),new JobName(entity.getJobName()),new OrderCode(entity.getOrderCode()),entity.getIsManager().booleanValue(),entity.getStartDate(),entity.getEndDate());
	}
	
	private List<JobHistory> toListJobHistory(List<JobHistoryTable> listEntity) {
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
		    entity.setJobId(jobHistory.getJobId());
		    entity.setJobName(jobHistory.getJobName().v());
		    entity.setOrderCode(jobHistory.getOrderCode().v());
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
	public void updateHistory(List<JobHistory> jobHistory) {
		for(JobHistory jobItem:jobHistory) {
		   this.commandProxy().update(this.toEntity(jobItem));
		}
		
	}


	@Override
	public List<JobHistory> findInDate(GeneralDate date) {
		List<JobHistory> listEntity=this.queryProxy().query(SELECT_BY_DATE,JobHistoryTable.class)
				                                   .setParameter("date", date)
		                                           .getList(c->toDomain(c));
		
		return listEntity;
	}

	@Override
	public List<JobHistory> findByJobId(String jobinforId) {
		
		List<JobHistory> listEntity=this.queryProxy().query(GET_ALL_BY_JOBID,JobHistoryTable.class)
				                                    .setParameter(":jobId", jobinforId)
				                                    .getList(c->toDomain(c));
		//List<JobHistory> listJobHis=toListJobHistory(listEntity);
		Collections.sort(listEntity);
		return listEntity;
	}

	@Override
	public List<JobHistory> findByJobCode(String jobCode) {
		List<JobHistory> listEntity=this.queryProxy().query(GET_ALL_BY_JOBCODE,JobHistoryTable.class)
				                                   .setParameter(":jobCode", jobCode)
				                                   .getList(c->toDomain(c));
		//List<JobHistory> listJobHis=toListJobHistory(listEntity);
		Collections.sort(listEntity);
		return listEntity;
	}

	@Override
	public void removeHis(JobHistory jobHistory) {
		this.commandProxy().remove(JobHistoryTable.class, jobHistory.getHistoryId());
		
	}

}
