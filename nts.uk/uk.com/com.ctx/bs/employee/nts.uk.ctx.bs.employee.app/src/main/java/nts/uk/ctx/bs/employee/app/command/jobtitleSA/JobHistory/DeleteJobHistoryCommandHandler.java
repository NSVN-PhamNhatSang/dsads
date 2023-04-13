package nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import lombok.val;
import nts.arc.layer.app.command.CommandHandler;
import nts.arc.layer.app.command.CommandHandlerContext;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistoryRepository;
@Stateless
public class DeleteJobHistoryCommandHandler extends CommandHandler<DeleteJobHistoryCommand>{
	@Inject
    JobHistoryRepository jobHistoryRepository;
	@Override
	protected void handle(CommandHandlerContext<DeleteJobHistoryCommand> context) {
	   val command =context.getCommand();
	   List<JobHistory> listJobHist= jobHistoryRepository.findByJobId(command.getJobId());
	   
	   JobHistory afterDeleteHist=listJobHist.get(listJobHist.size()-2);
	   afterDeleteHist.setEndDate(GeneralDate.max());
	   jobHistoryRepository.removeHis(listJobHist.get(listJobHist.size()-1));
	   listJobHist.remove(listJobHist.size()-1);
	   jobHistoryRepository.updateHistory(listJobHist);
	   
		
	}
	
	

}
