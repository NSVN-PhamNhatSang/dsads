package nts.uk.ctx.bs.employee.app.find.jobtitleSA.Dto;

import lombok.Getter;
import lombok.Setter;
import nts.arc.time.GeneralDate;
@Getter
@Setter
public class JobHistoryFinderDTO {
private String historyId;
    
    private String jobId;
    
    private String jobName ;
	  
    private String orderCode;
	  
    private Boolean isManager;
    
    private GeneralDate startDate;
    
    private GeneralDate endDate;
}
