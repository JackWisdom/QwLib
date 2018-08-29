package git.jw.mcp.qwzd.date;

import git.jw.mcp.qwzd.QwLib;

import java.util.Calendar;
import java.util.Date;

public class DateManager {
  public int year=2018;
  public int month=5;
  public int day=4;
  public int hour=3;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinaute() {
        return minaute;
    }

    public int minaute=30;
  public DateManager(){
      reflush();

  }
  public void reflush(){
      Calendar calendar=Calendar.getInstance();
      year=calendar.get(Calendar.YEAR);
      month=calendar.get(Calendar.MONTH);
      day=calendar.get(Calendar.DATE);
      hour=calendar.get(Calendar.HOUR_OF_DAY);
      minaute=calendar.get(Calendar.SECOND);
  }
}
