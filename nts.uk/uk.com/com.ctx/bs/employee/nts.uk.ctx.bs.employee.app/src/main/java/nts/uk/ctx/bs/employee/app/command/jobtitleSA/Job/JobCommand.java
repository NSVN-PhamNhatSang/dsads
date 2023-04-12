package nts.uk.ctx.bs.employee.app.command.jobtitleSA.Job;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobCommand {
        private String jobId;
        
        private String jobCode;
        
        private boolean isAbolition;
}
