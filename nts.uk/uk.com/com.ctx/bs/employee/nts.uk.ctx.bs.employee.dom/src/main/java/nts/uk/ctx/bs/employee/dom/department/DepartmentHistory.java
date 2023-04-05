/******************************************************************
 * Copyright (c) 2017 Nittsu System to present.                   *
 * All right reserved.                                            *
 *****************************************************************/
package nts.uk.ctx.bs.employee.dom.department;

import lombok.Getter;
import nts.arc.time.GeneralDate;
import nts.uk.shr.com.history.HistoryItem;
import nts.arc.time.calendar.period.DatePeriod;

/**
 * The Class DepartmentHistory.
 */
@Getter
// 部門履歴
public class DepartmentHistory extends HistoryItem<DatePeriod, GeneralDate> {

	/** The id. */
	/* 履歴ID */
	private String id;

	/** The period. */
	/* 期間 */
	private DatePeriod period;

	/*
	 * (non-Javadoc)
	 * 
	 * @see nts.uk.shr.com.history.HistoryItem#span()
	 */
	@Override
	public DatePeriod span() {
		return this.period;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nts.uk.shr.com.history.HistoryItem#identifier()
	 */
	@Override
	public String identifier() {
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nts.uk.shr.com.history.HistoryItem#changeSpan(nts.uk.shr.com.time.
	 * calendar.period.GeneralPeriod)
	 */
	@Override
	public void changeSpan(DatePeriod newSpan) {
		this.period = newSpan;
	}
}
