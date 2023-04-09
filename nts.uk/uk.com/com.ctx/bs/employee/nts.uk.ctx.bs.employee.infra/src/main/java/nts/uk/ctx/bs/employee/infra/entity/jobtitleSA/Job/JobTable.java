package nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.Job;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.shr.infra.data.entity.ContractUkJpaEntity;
@Getter
@Setter
@Entity
@Table(name = "Job")
public class JobTable extends ContractUkJpaEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
	@Basic(optional = false)
	@Column(name = "JOBID")
	protected JobTablePK jobId;
    
    @Column(name = "JOBCODE")
	private JobCode jobCode;
	

	@Column(name = "ISABOLITION")
	private Boolean isAbolition;
	
	
	
	@Override
	protected Object getKey() {
		return this.jobId;
	}

}
