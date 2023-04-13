package nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.Job;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.shr.infra.data.entity.ContractUkJpaEntity;
@Getter
@Setter
@Entity
@Table(name = "JOB_TABLE")
public class JobTable extends ContractUkJpaEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
	@Basic(optional = false)
	@Column(name = "JOB_ID")
	protected String jobId;
    
    @Column(name = "JOB_CODE")
	private String jobCode;
	

	@Column(name = "IS_ABOLITION")
	private Boolean isAbolition;
	
	
	
	@Override
	protected Object getKey() {
		return this.jobId;
	}

}
