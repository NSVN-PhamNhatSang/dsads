package nts.uk.ctx.bs.employee.app.command.jobtitleSA.Job;

import java.util.Optional;

import lombok.val;
import nts.arc.layer.app.command.CommandHandlerContext;
import nts.arc.layer.app.command.CommandHandlerWithResult;
import nts.gul.text.IdentifierUtil;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.Job;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobRepository;

public class AddJobCommandHandler extends CommandHandlerWithResult<JobCommand,String>{
     private JobRepository jobRepository;
	@Override
	protected String handle(CommandHandlerContext<JobCommand> context) {
		val command=context.getCommand();
		String jobId=IdentifierUtil.randomUniqueId();
		Job job=new Job(jobId,command.isAbolition(),new JobCode(command.getJobCode()));
		Optional<Job> jobItem=this.jobRepository.findByJobCode(job.getJobCode().v());
		if(!jobItem.isPresent()) {
		jobRepository.addJob(job);
		return jobId;
		}
		
		return null;
	}
       
}
