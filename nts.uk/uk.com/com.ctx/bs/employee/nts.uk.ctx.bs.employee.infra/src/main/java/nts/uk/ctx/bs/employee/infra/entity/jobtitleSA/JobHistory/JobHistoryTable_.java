package nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.JobHistory;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import nts.arc.time.GeneralDate;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.history.JobName;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobCode;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.jobOrder.OrderCode;


@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-16T13:40:38")
@StaticMetamodel(JobHistoryTable.class)
public class JobHistoryTable_ {
	 public static volatile SingularAttribute<JobHistoryTable, String> historyId;
	 public static volatile SingularAttribute<JobHistoryTable, String> jobId;
	 public static volatile SingularAttribute<JobHistoryTable, String> jobName;
	 public static volatile SingularAttribute<JobHistoryTable, String> orderCode;
	 public static volatile SingularAttribute<JobHistoryTable, Boolean> isManager;
	 public static volatile SingularAttribute<JobHistoryTable, GeneralDate> startDate;
	 public static volatile SingularAttribute<JobHistoryTable, GeneralDate> endDate;
}
