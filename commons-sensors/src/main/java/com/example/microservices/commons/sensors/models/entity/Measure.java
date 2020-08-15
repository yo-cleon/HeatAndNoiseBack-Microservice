package com.example.microservices.commons.sensors.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "measures")
public class Measure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@JsonIgnoreProperties(value= {"measures"})
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "sensor_id")
	@NotNull(message = "The Sensor field can not be null")
	private Long sensor;

	private int noise = 0;
	
	private Double temperature = 0.00;
	
	private Double humidity = 0.00;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date taken;
	
	@PrePersist
	public void prePersist() {
		this.taken = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getSensor() {
		return sensor;
	}

	public void setSensor(Long sensorId) {
		this.sensor = sensorId;
	}
	public int getNoise() {
		return noise;
	}

	public void setNoise(int noise) {
		this.noise = noise;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Date getTaken() {
		return taken;
	}

	public void setTaken(Date taken) {
		this.taken = taken;
	}	

}
