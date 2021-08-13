package be.lamattina.jframe;

import java.awt.Color;
import java.util.Date;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.IDateEvaluator;

public class RangeEvaluator implements IDateEvaluator {
	private DateUtil date = new DateUtil();

	@Override
	public Color getInvalidBackroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getInvalidForegroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInvalidTooltip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getSpecialBackroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getSpecialForegroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSpecialTooltip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInvalid(Date arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSpecial(Date arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//
	public void setStartDate(Date startDate) {
		date.setMinSelectableDate(startDate);
	}
	public Date getStartDate() {
        return date.getMinSelectableDate();
    }
    public void setEndDate(Date endDate) {
        date.setMaxSelectableDate(endDate);
    }
    public Date getEndDate() {
        return date.getMaxSelectableDate();
    }  

}
