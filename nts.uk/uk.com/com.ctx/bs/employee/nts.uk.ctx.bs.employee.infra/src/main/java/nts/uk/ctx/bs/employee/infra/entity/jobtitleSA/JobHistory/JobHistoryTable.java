package nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.JobHistory;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import nts.arc.layer.infra.data.entity.type.GeneralDateToDBConverter;
import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobName;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;
import nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.Job.JobTablePK;
import nts.uk.shr.infra.data.entity.ContractUkJpaEntity;
@Getter
@Setter
@Entity
@Table(name = "Job")
public class JobHistoryTable extends ContractUkJpaEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "HISTORYID")
	private String historyId;
	
	@Column(name = "JOBID")
	private String jobId;
	
	@Column(name = "JOBNAME")
	private JobName jobName;
	
	@Column(name = "ORDERCODE")
	private OrderCode orderCode;
	
	@Column(name = "ISMANAGER")
	private Boolean isManager;
	
	@Column(name = "STARTDATE")
	@Convert(converter = GeneralDateToDBConverter.class)
    private GeneralDate startDate;
	
	@Column(name = "ENDDATE")
	@Convert(converter = GeneralDateToDBConverter.class)
    private GeneralDate endDate;
	@Override
	protected Object getKey() {
		return this.historyId;
	}

}
