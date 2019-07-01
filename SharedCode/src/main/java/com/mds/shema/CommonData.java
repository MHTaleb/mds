package com.mds.shema;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mds.shema.utils.SecurityUtils;

import lombok.Data;

@MappedSuperclass
@Data
public class CommonData {
	/*
	donord
	datmaj
	deruser
	derprg
	indicmaj
	indtrans
	*/
	/**
	 *  N VARCHAR2(13) Donneur d’ordre (Code enseigne / société propriétaire des données )
	 * */
	@Column(name="DONORD",nullable=false,length=13)
	private  String donord; 

	
	/**
	 * N SYSDATE DATE Date de création
	 * */
	@Column(name="DATCRE",nullable=false,updatable=false,columnDefinition="DATE DEFAULT CURRENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private  Date datcre = new Date();
	
	/**
	 *  N SYSDATE DATE Date de derniere mise a jour
	 * */
	@Column(name="DATMAJ",nullable=false,columnDefinition="DATE DEFAULT CURRENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private  Date datmaj = new Date() ;
	
	/**
	 * N VARCHAR2(13) Dernier utilisateur
	 * */
	@Column(name="DERUSER",nullable=false,length=13)
	private  String deruser ;
	
	/**
	 * N VARCHAR2(13) Dernier programme
	 * */
	@Column(name="DERPRG",nullable=false,length=13)
	private  String derprg ;
	
	/**
	 * Y NUMBER Indicateur de mise a jour
	 * */
	@Column(name="INDICMAJ",nullable=true,precision=13)
	private  Long indicmaj;
	
	/**
	 * Y NUMBER Indicateur de transmission des données
	 * */
	@Column(name="INDTRANS",nullable=true,precision=13)
	private  Long indtrans;

	
	
	@PrePersist
	void onCreate() {
		if(getDonord() == null ) {
			setDonord("undifined");
		}
		
		if( getDerprg() == null) {
			setDerprg("undifined");
		}
		
		if(getDeruser() == null ) {
			setDeruser("undifined");
		}
		
		setIndicmaj(0L);
		setIndtrans(0L);
	}
	
	@PreUpdate
	void OnUpdate() {
		setDonord(SecurityUtils.currentUser.getName());
		
		if(getDerprg().trim().isEmpty() || getDerprg() == null) {
			setDerprg("undifined");
		}
		
		setDeruser("undifined");
		
		setIndicmaj(getIndicmaj()+1);
		setIndtrans(getIndtrans());
		
	}
	
	
}
