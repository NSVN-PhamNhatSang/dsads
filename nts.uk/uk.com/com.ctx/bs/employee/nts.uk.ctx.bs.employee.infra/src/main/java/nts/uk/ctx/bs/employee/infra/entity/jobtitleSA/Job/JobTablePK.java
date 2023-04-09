package nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.Job;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class JobTablePK {
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "JOBID")
	private String jobId;
}
