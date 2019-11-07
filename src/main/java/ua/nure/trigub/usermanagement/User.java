package ua.nure.trigub.usermanagement;
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
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = 0;
		int currentMonth = 1;
		int currentDay = 0;
			currentYear= calendar.get(Calendar.YEAR);//текущая дата
			currentMonth += calendar.get(Calendar.MONTH);
			currentDay= calendar.get(Calendar.DAY_OF_MONTH);
		calendar.setTime(getDateOfBirth());
			int birthYear = calendar.get(Calendar.YEAR);// дата ДР
			int birthDay= calendar.get(Calendar.DAY_OF_MONTH);
			int birthMonth= calendar.get(Calendar.MONTH);
			int age = 0;
		if(birthMonth>currentMonth) {
			age = currentYear - birthYear - 1;//др в будущем, не в этом месце, тест 5, все ок
		}
		if (birthMonth<currentMonth) {
			age = currentYear - birthYear; //др в прошедших месяцах, тест 1, все ок
		}
		if (birthMonth==currentMonth) {
			if(birthDay<currentDay) {
				age = currentYear - birthYear;//др прошло но было в текущем месяце (ожид 19, но было 18, почему???) тест 2
			}
			if(birthDay==currentDay) {
				age = currentYear - birthYear;// сегодня, аналогичная ошибка, тест 3
			}
			if (birthDay>currentDay) {
				age = currentYear - birthYear - 1; //tomorrow
			}
		}	
		return age;
	}
}
