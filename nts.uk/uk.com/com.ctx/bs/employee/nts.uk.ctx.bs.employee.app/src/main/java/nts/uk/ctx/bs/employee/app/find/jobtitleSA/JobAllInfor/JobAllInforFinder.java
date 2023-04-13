package nts.uk.ctx.bs.employee.app.find.jobtitleSA.JobAllInfor;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.app.find.jobtitleSA.Dto.JobFinderDTO;
import nts.uk.ctx.bs.employee.app.find.jobtitleSA.Dto.JobHistoryFinderDTO;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistoryRepository;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.Job;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobRepository;

@Getter
@Setter
@Stateless
public class JobAllInforFinder {
	   @Inject
       private JobRepository jobRepository;
	   
	   @Inject
       private JobHistoryRepository jobHistoryRepository;
       
      public  List<JobFinderDTO> findByDate(GeneralDate today){
    	   
    	   List<JobFinderDTO> listJobFinderDto= new ArrayList<>();
    	   
    	   List<Job> listJob=jobRepository.findByDate(today);
    	   
    	   for(Job jobItem:listJob){
    		   JobFinderDTO jobDtoItem=new JobFinderDTO();
    		   List<JobHistory> jobHistoryItem=jobHistoryRepository.findByJobId(jobItem.getJobInforId());
    		   jobDtoItem.setJobCode(jobItem.getJobCode().v());
    		   jobDtoItem.setJobId(jobItem.getJobInforId());
    		   jobDtoItem.setJobName(jobHistoryItem.get(0).getJobName().v());
    		   listJobFinderDto.add(jobDtoItem);
    		   
    	   }
    	   return listJobFinderDto;
    	   
       }
       
      public   List<JobHistoryFinderDTO> findByJobId(String jobId){
    	   List<JobHistoryFinderDTO> listJobHistDTO= new ArrayList<>();
    	   
    	   List<JobHistory> listJobHist=jobHistoryRepository.findByJobId(jobId);
    	   
    	   for(JobHistory jobHistItem:listJobHist){
    		   JobHistoryFinderDTO jobHisDTO=new JobHistoryFinderDTO();
    		   jobHisDTO.setHistoryId(jobHistItem.getHistoryId());
    		   jobHisDTO.setJobId(jobId);
    		   jobHisDTO.setJobName(jobHistItem.getJobName().v());
    		   jobHisDTO.setOrderCode(jobHistItem.getOrderCode().v());
    		   jobHisDTO.setIsManager(jobHistItem.isManager());
    		   jobHisDTO.setEndDate(jobHistItem.getEndDate());
    		   jobHisDTO.setStartDate(jobHistItem.getStartDate());
    		   listJobHistDTO.add(jobHisDTO);
    		   
    	   }
    	   return listJobHistDTO;
    	    
       }
       
       
       
       
       
       
       
       
}
