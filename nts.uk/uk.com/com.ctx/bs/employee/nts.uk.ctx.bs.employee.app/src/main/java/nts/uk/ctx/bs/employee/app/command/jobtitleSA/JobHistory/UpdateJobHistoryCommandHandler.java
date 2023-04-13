package nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

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

@Stateless
public class UpdateJobHistoryCommandHandler extends CommandHandler<List<JobHistoryCommand>>{
	@Inject
	JobHistoryRepository jobHistoryRepository;

	@Override
	protected void handle(CommandHandlerContext<List<JobHistoryCommand>> context) {
		val command=context.getCommand();
		List<JobHistory> listJobHist= new ArrayList<>();
		//validateUpdate(listJobHist.get(listJobHist.size()-2),jobHistory);
		for(JobHistoryCommand commandItem:command) {
			listJobHist.add(commandItem.toDomain());
		}
		jobHistoryRepository.updateHistory(listJobHist);
		
	}
	
/*	private void validateUpdate(JobHistory lastJobHistory, JobHistory updateJobHistory){
		boolean isError = false;
		BundledBusinessException exceptions = BundledBusinessException.newInstance();
		
		if(lastJobHistory.compareTo(updateJobHistory)>=0 || updateJobHistory.getStartDate().after(lastJobHistory.getStartDate())){
			isError=true;
			exceptions.addMessage("Msg_1000");
		}
		
		if (isError) {
			exceptions.throwExceptions();
		}
	}*/
	
	

}
