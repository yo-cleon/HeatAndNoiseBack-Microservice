package com.example.microservices.commons.sensors.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "sensors")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mac;
	
	private String position;
	
	
	private boolean estado;
	
	@Column(name = "created_at")
	private Date createdAt;
	
//	@JsonIgnoreProperties(value= {"sensor"}, allowSetters = true)
	@OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Measure> measures;
	
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}

	public Sensor() {
		this.measures = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isStatus() {
		return estado;
	}

	public void setStatus(boolean status) {
		this.estado = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Measure> getMeasures() {
		return measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures.clear();
		measures.forEach(this::addMeasure);
	}
	
	public void addMeasure(Measure measure) {
		this.measures.add(measure);
		measure.setSensor(this.id);
	}
	
	public void removeMeasure(Measure measure) {
		this.measures.remove(measure);
		measure.setSensor(null);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if (!(obj instanceof Measure)) {
			return false;
		}
		Measure m = (Measure) obj;
		
		return this.id != null && this.id.equals(m.getId());
	}
}
