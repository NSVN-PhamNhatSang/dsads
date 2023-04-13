package nts.uk.ctx.bs.employee.ws.jobtitleSA;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nts.arc.layer.ws.WebService;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.app.command.jobtitleSA.Job.AddJobCommandHandler;
import nts.uk.ctx.bs.employee.app.command.jobtitleSA.Job.JobCommand;
import nts.uk.ctx.bs.employee.app.command.jobtitleSA.Job.UpdateJobCommandHandler;
import nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory.AddJobHistoryCommandHandler;
import nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory.DeleteJobHistoryCommand;
import nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory.DeleteJobHistoryCommandHandler;
import nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory.JobHistoryCommand;
import nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory.UpdateJobHistoryCommandHandler;
import nts.uk.ctx.bs.employee.app.find.jobtitleSA.Dto.JobFinderDTO;
import nts.uk.ctx.bs.employee.app.find.jobtitleSA.Dto.JobHistoryFinderDTO;
import nts.uk.ctx.bs.employee.app.find.jobtitleSA.JobAllInfor.JobAllInforFinder;

@Path("bs/employee/jobtitleSA")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class JobTitleSAWebService extends WebService{
       
	@Inject
	private JobAllInforFinder jobAllFinder;
	
	@Inject
	private AddJobHistoryCommandHandler addJobHistoryCommandHandler;
	
	@Inject
	private DeleteJobHistoryCommandHandler deleteJobHistoryCommandHandler;
	
	@Inject
	private UpdateJobHistoryCommandHandler updateJobHistoryCommandHandler;
	
	@Inject
	private AddJobCommandHandler addJobCommandHandler;
	
	@Inject
	private UpdateJobCommandHandler updateJobCommandHandler;
	
	
	
	
	@Path("findByDate")
	@POST
	public List<JobFinderDTO> findByDate(GeneralDate today){
		return this.jobAllFinder.findByDate(today);
	}
	
	@Path("findByJobId")
	@POST
	public List<JobHistoryFinderDTO> findByJobId(String jobId){
		return this.jobAllFinder.findByJobId(jobId);
	}
	
	@Path("addJob")
	@POST
	public void addJob(JobHistoryCommand jobHisCommand,JobCommand jobCommand) {
		String jobId=addJobCommandHandler.handle(jobCommand);
		jobHisCommand.setJobId(jobId);
		addJobHistoryCommandHandler.handle(jobHisCommand);
	}
	
	@Path("addHis")
	@POST
	public void addHis(JobHistoryCommand jobHisCommand) {
		 this.addJobHistoryCommandHandler.handle(jobHisCommand);
	}
	
	@Path("updateHis")
	@POST
	public void updateHis(List<JobHistoryCommand> listHisCommand) {
		 this.updateJobHistoryCommandHandler.handle(listHisCommand);
	}
	
	@Path("deleteHis")
	@POST
	public void deleteHis(DeleteJobHistoryCommand delJobHisCommand) {
		 this.deleteJobHistoryCommandHandler.handle(delJobHisCommand);
	}
	
       
}
