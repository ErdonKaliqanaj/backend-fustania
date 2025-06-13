package com.fustania.backendfustania.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "dresses")
public class Dress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
	@NotBlank(message = "Titulli është i detyrueshëm ")
	@Size(max = 100, message="Titulli nuk mund te jetë më i gjatë se 25 karaktere")
	private String title;

	@NotBlank
	private String dizajneri;
	
	@NotBlank
	private String masa;
	
	@Positive
	private double cmimi;
	
	@NotBlank
	private String ngjyra;
	
	@NotBlank String shteti;
	private String qyteti;
	
	@ManyToOne
	@JoinColumn (name = "seller_id", referencedColumnName = "id")
	private User seller;
	
	public Long getId() {
		return id;
	}
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDizjaneri() {
		return dizajneri;
	}
	public void setDizajneri (String dizajneri) { 
		this.dizajneri = dizajneri;
	}
	
	public String getMasa() {
		return masa;
	}
	public void setMasa(String masa) {
		this.masa = masa;
	}
	
	public double getCmimi() {
		return cmimi;
	}
	public void setCmimi(double cmimi) {
			this.cmimi = cmimi;
		}
	
	public String getNgjyra() {
		return ngjyra;
	}
	public void setNgjyra(String ngjyra) {
		this.ngjyra = ngjyra;
	}
	
	public String getShteti() {
		return shteti;
	}
	public void setShteti(String shteti) {
		this.shteti = shteti;
	}
	
	public String getQyteti() {
		return qyteti;
	}
	public void setQyteti(String qyteti) {
		this.qyteti = qyteti;
	}
	
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	
	
	

}
