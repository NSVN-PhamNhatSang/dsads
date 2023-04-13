package nts.uk.ctx.bs.employee.app.command.jobtitleSA.JobHistory;

import lombok.Getter;
import lombok.Setter;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobHistory;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobName;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;

@Getter
@Setter
public class JobHistoryCommand {
	private String historyId;
    
    private String jobId;
    
    private String jobName ;
	  
    private String orderCode;
	  
    private Boolean isManager;
    
    private GeneralDate startDate;
    
    private GeneralDate endDate;
    
    public JobHistory toDomain() {
    	return new JobHistory(this.historyId,this.jobId,new JobName(this.jobName),new OrderCode(this.orderCode),this.isManager.booleanValue(),this.startDate,this.endDate);
    }
}
