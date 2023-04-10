package nts.uk.ctx.bs.employee.app.command.jobtitleSA.dto;

import lombok.Getter;
import lombok.Setter;
import nts.arc.time.GeneralDate;
import nts.gul.text.IdentifierUtil;
import nts.gul.text.StringUtil;
@Setter
@Getter
public class JobHistoryDto {
      private String historyId;
      
      private String jobCode;
      
      private String jobName ;
	  
      private String orderCode;
	  
      private Boolean isManager;
      
      private GeneralDate startDate;
      
      private GeneralDate endDate;
      
      public String getHistoryId(){
    	  if(StringUtil.isNullOrEmpty(this.historyId,true)){
    		  this.historyId=IdentifierUtil.randomUniqueId();
    	  }
    	  return this.historyId;
      }
}
