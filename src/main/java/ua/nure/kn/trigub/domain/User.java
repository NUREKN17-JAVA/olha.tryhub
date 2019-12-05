package ua.nure.kn.trigub.domain;

import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirthd;

	public User(Long id, String firstName, String lastName, Date date) {
		this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirthd = date;
    }

	public User(String firstName, String lastName, Date date) {
		  this.firstName = firstName;
	        this.lastName = lastName;
	        this.dateOfBirthd = date;
	}
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirthd() {
		return dateOfBirthd;
	}

	public void setDateOfBirthd(Date dateOfBirthd) {
		this.dateOfBirthd = dateOfBirthd;
	}

	public String getFullName() {
		if (getLastName() == "" || getLastName() == " " || getLastName() == null) {
			return getFirstName();
		} else if (getFirstName() == "" || getFirstName() == " " || getFirstName() == null) {
			return getLastName();
		} else {
			return getLastName() + ", " + getFirstName();
		}
	}

	public long getAge() {
		Calendar calendarCurrent = Calendar.getInstance();
		calendarCurrent.setTime(new Date());

		Calendar calendarBirthd = Calendar.getInstance();
		calendarBirthd.setTime(getDateOfBirthd());

		int age = calendarCurrent.get(Calendar.YEAR) - calendarBirthd.get(Calendar.YEAR);

		if ((calendarCurrent.get(Calendar.MONTH) == calendarBirthd.get(Calendar.MONTH))
				&& (calendarCurrent.get(Calendar.DAY_OF_MONTH) > calendarBirthd.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}

		if (calendarCurrent.get(Calendar.MONTH) > calendarBirthd.get(Calendar.MONTH))
			age--;

		return age;
	}
}