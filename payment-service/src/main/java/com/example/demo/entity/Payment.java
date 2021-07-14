package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;


@Data
@Entity
@Table(name="payments")
public class Payment {

	@Id
	@Column(name="txnId")
	private int txtId;
	private String description;
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="txnDate")
	private LocalDate txnDate;
	private double amount;
}
