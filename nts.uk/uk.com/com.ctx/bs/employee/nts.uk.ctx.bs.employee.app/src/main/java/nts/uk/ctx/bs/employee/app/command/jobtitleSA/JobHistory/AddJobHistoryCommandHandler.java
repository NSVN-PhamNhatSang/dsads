package nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory;

import java.util.List;


import lombok.val;
import nts.arc.error.BundledBusinessException;
import nts.arc.layer.app.command.CommandHandlerContext;
import nts.arc.layer.app.command.CommandHandlerWithResult;
import nts.gul.text.IdentifierUtil;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistoryRepository;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobName;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;

public class AddJobHistoryCommandHandler extends CommandHandlerWithResult<JobHistoryCommand,String>{
	
	private JobHistoryRepository jobHistoryRepository;
	@Override
	protected String handle(CommandHandlerContext<JobHistoryCommand> context) {
		val command=context.getCommand();
		List<JobHistory> listJobHist=jobHistoryRepository.findByJobId(command.getJobId());
		String historyId=IdentifierUtil.randomUniqueId();
		if(listJobHist.size()==0){
		JobHistory jobHistory=new JobHistory(historyId, command.getJobId(),new JobName(command.getJobName()),new OrderCode(command.getOrderCode()),command.getIsManager().booleanValue(),command.getStartDate(),command.getEndDate());
		jobHistoryRepository.addHistory(jobHistory);
		}else{
			JobHistory jobHistory=new JobHistory(historyId,command.getJobId(),new JobName(command.getJobName()),new OrderCode(command.getOrderCode()),command.getIsManager().booleanValue(),command.getStartDate(),command.getEndDate());

			validateAdd(listJobHist.get(listJobHist.size()-1),jobHistory);
			jobHistoryRepository.addHistory(jobHistory);
			
		}
		return historyId;
	}
	
	private void validateAdd(JobHistory lastHistory, JobHistory addHistory){
		boolean isError = false;
		BundledBusinessException exceptions = BundledBusinessException.newInstance();
	   if(lastHistory.compareTo(addHistory)>=0){
		isError=true;
		exceptions.addMessage("Msg_1000");   
	   }
	   
	   if (isError) {
			exceptions.throwExceptions();
		}
	   
	}

}
