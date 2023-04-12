package nts.uk.ctx.bs.employee.infra.repository.jobtitleSA.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import nts.arc.layer.infra.data.JpaRepository;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobName;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.Job;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobRepository;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;
import nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.Job.JobTable;
import nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.Job.JobTablePK;

public class JpaJobRepository extends JpaRepository implements JobRepository{
	
	
	private static final String SELECT_JOBINFOR_DATE = "SELECT h.jobId,h.isAbolition,h.jobCode FROM JobTable h, JobHistoryTable j where h.jobId=j.jobId AND j.startDate<= :date AND :date<= j.endDate";

    private JobTable toEntity(Job job){
    	    JobTable entity= this.queryProxy()
    	    		.find(new JobTablePK(job.getJobInforId()),  JobTable.class)
    	    		.orElse(new JobTable());
    	    entity.setJobId(new JobTablePK(job.getJobInforId()));
    	    entity.setJobCode(job.getJobCode());
    	    entity.setIsAbolition(new Boolean(job.isAbolition()));
    	    
    	    return entity;
    }
    private Job toDomain(Object[] entity) {
		return new Job(String.valueOf(entity[0].toString()), (boolean)entity[1], new JobCode(String.valueOf(entity[3].toString())));
				
	}
    
    private List<Job> toListJob(List<Object[]> listEntity) {
		List<Job> lstJob = new ArrayList<>();
		if (!listEntity.isEmpty()) {
			listEntity.stream().forEach(c -> {
				Job job = toDomain(c);
				
				lstJob.add(job);
			});
		}
		return lstJob;
	}
	@Override
	public void addJob(Job job) {
		this.commandProxy().insert(this.toEntity(job));
		
	}

	@Override
	public void updateJob(Job job) {
		this.commandProxy().update(this.toEntity(job));
		
	}

	@Override
	public Optional<Job> findByJobInforId(String jobInforId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Job> findByHistoryId(String historyId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Job> findByDate(GeneralDate today) {
		
		List<Object[]> listEntity=this.queryProxy().query(SELECT_JOBINFOR_DATE,Object[].class)
                .setParameter("date", today)
                .getList();
		
		return toListJob(listEntity);
	}

}
