package nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteJobHistoryCommand {
       private String historyId;
       
       private String jobId;
}
