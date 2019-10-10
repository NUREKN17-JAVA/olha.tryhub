package ua.nure.trigub.usermanagement;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFullName() {
		return getLastName() + getFirstName();
	}
	
	public int getAge() {
		int age = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear= calendar.get(Calendar.YEAR);
		int currentMonth= calendar.get(Calendar.MONTH);
		int currentDay= calendar.get(Calendar.DAY_OF_MONTH);
		calendar.setTime(getDateOfBirth());
		int birthYear = calendar.get(Calendar.YEAR);
		int birthDay= calendar.get(Calendar.DAY_OF_MONTH);
		int birthMonth= calendar.get(Calendar.MONTH);
		int age1=currentYear - birthYear;
		int age2 = currentYear - birthYear - 1;
			if (birthMonth<currentMonth) { 
				age = age1;}
			if(birthMonth>currentMonth) {
				age = age2;}
			if (birthMonth==currentMonth&&birthDay>currentDay) {
				age = age2;} //tomorrow
			if (birthMonth==currentMonth&&birthDay<currentDay) {
					age = age1;} //was yesterday
			if(birthMonth==currentMonth&&birthDay==currentDay) {
					age = age1; }// today
							
		return age;
		
		
	}
	
    


}
