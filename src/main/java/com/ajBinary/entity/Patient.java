package com.ajBinary.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	@Column(nullable = false)
	private String firstName, midName, lastName, payersName, paymentType, asgnProvider;
	private int age;
	public Patient(Long memberId, String firstName, String midName, String lastName, String payersName,
			String paymentType, String asgnProvider, int age) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.payersName = payersName;
		this.paymentType = paymentType;
		this.asgnProvider = asgnProvider;
		this.age = age;
	}
	public Patient() {
		super();
	}
	public Patient(String firstName, String midName, String lastName, String payersName, String paymentType,
			String asgnProvider, int age) {
		super();
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.payersName = payersName;
		this.paymentType = paymentType;
		this.asgnProvider = asgnProvider;
		this.age = age;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPayersName() {
		return payersName;
	}
	public void setPayersName(String payersName) {
		this.payersName = payersName;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getAsgnProvider() {
		return asgnProvider;
	}
	public void setAsgnProvider(String asgnProvider) {
		this.asgnProvider = asgnProvider;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, asgnProvider, firstName, lastName, memberId, midName, payersName, paymentType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return age == other.age && Objects.equals(asgnProvider, other.asgnProvider)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(memberId, other.memberId) && Objects.equals(midName, other.midName)
				&& Objects.equals(payersName, other.payersName) && Objects.equals(paymentType, other.paymentType);
	}
	@Override
	public String toString() {
		return "Patient [memberId=" + memberId + ", firstName=" + firstName + ", midName=" + midName + ", lastName="
				+ lastName + ", payersName=" + payersName + ", paymentType=" + paymentType + ", asgnProvider="
				+ asgnProvider + ", age=" + age + "]";
	}
	
	
	
	
	

	
}
