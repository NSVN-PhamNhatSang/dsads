package nts.uk.ctx.bs.employee.app.command.jobtitleSA.Job;

import lombok.val;
import nts.arc.layer.app.command.CommandHandler;
import nts.arc.layer.app.command.CommandHandlerContext;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.Job;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobRepository;


public class UpdateJobCommandHandler extends CommandHandler<JobCommand>{
    private JobRepository jobRepository;
    
	@Override
	protected void handle(CommandHandlerContext<JobCommand> context) {
		val command=context.getCommand();
		Job job= new Job(command.getJobId(),command.isAbolition(),new JobCode(command.getJobCode()));
		jobRepository.updateJob(job);
	}

}
