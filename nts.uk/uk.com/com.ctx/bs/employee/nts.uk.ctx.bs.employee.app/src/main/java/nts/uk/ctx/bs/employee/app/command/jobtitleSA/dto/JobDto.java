package nts.uk.ctx.bs.employee.app.command.jobtitleSA.dto;

import lombok.Getter;
import lombok.Setter;
import nts.gul.text.IdentifierUtil;
import nts.gul.text.StringUtil;


@Setter
@Getter
public class JobDto {
      private String jobInforId;
      
      private String jobCode;
      
      private Boolean isAbolition;
      
     
      public String getJobInforId(){
    	  if(StringUtil.isNullOrEmpty(this.jobInforId, true)){
    		  this.jobInforId=IdentifierUtil.randomUniqueId();
    	  }
    	  return this.jobInforId;
      }
}
