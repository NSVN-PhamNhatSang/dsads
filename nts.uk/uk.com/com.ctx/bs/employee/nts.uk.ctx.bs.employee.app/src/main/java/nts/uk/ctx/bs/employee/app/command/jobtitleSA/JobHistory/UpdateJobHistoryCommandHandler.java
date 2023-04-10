package nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory;

import java.util.List;

import lombok.val;
import nts.arc.error.BundledBusinessException;
import nts.arc.layer.app.command.CommandHandler;
import nts.arc.layer.app.command.CommandHandlerContext;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistoryRepository;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobName;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;

public class UpdateJobHistoryCommandHandler extends CommandHandler<JobHistoryCommand>{
	JobHistoryRepository jobHistoryRepository;

	@Override
	protected void handle(CommandHandlerContext<JobHistoryCommand> context) {
		val command=context.getCommand();
		List<JobHistory> listJobHist= jobHistoryRepository.findByJobId(command.getJobId());
		JobHistory jobHistory=new JobHistory(command.getHistoryId(),command.getJobId(),new JobName(command.getJobName()), new OrderCode(command.getOrderCode()),command.getIsManager().booleanValue(),command.getStartDate(),command.getEndDate());
		//validateUpdate(listJobHist.get(listJobHist.size()-2),jobHistory);
		if(listJobHist.size()>1){
			validateUpdate(listJobHist.get(listJobHist.size()-2),jobHistory);
			JobHistory beforeLastJobHistory=listJobHist.get(listJobHist.size()-2);
			beforeLastJobHistory.setEndDate(jobHistory.updateStartDate(jobHistory.getStartDate()));
			jobHistoryRepository.updateHistory(beforeLastJobHistory);
		}   
		   // jobHistory.validate();
		    jobHistoryRepository.updateHistory(jobHistory);
		
	}
	
	private void validateUpdate(JobHistory lastJobHistory, JobHistory updateJobHistory){
		boolean isError = false;
		BundledBusinessException exceptions = BundledBusinessException.newInstance();
		
		if(lastJobHistory.compareTo(updateJobHistory)>=0 || updateJobHistory.getStartDate().after(lastJobHistory.getStartDate())){
			isError=true;
			exceptions.addMessage("Msg_1000");
		}
		
		if (isError) {
			exceptions.throwExceptions();
		}
	}
	
	

}
