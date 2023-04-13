package nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import lombok.val;
import nts.arc.error.BundledBusinessException;
import nts.arc.error.BusinessException;
import nts.arc.layer.app.command.CommandHandlerContext;
import nts.arc.layer.app.command.CommandHandlerWithResult;
import nts.gul.text.IdentifierUtil;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistoryRepository;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobName;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;
@Stateless
public class AddJobHistoryCommandHandler extends CommandHandlerWithResult<JobHistoryCommand,String>{
	@Inject
	private JobHistoryRepository jobHistoryRepository;
	@Override
	protected String handle(CommandHandlerContext<JobHistoryCommand> context) {
		val command=context.getCommand();
		List<JobHistory> listJobHist=jobHistoryRepository.findByJobId(command.getJobId());
		String historyId=IdentifierUtil.randomUniqueId();
		JobHistory jobHistory=new JobHistory(historyId, command.getJobId(),new JobName(command.getJobName()),new OrderCode(command.getOrderCode()),command.getIsManager().booleanValue(),command.getStartDate(),command.getEndDate());

		if(listJobHist.size()==0){
		jobHistoryRepository.addHistory(jobHistory);
		}else{
			validateAdd(listJobHist.get(listJobHist.size()-1),jobHistory);
			jobHistoryRepository.addHistory(jobHistory);
			
		}
		return historyId;
	}
	
	private void validateAdd(JobHistory lastHistory, JobHistory addHistory){
		
	   if(lastHistory.compareTo(addHistory)>=0){
		
		throw new BusinessException("Msg_1000");
	   }
	   
	   
	   
	}

}
