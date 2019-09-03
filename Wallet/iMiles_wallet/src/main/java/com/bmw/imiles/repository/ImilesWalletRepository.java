package com.bmw.imiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bmw.imiles.entity.Imiles;
/**
 * 
 * @author avadheshkumar
 *
 */
public interface ImilesWalletRepository extends JpaRepository<Imiles, Long> {

	@Query("SELECT imiles FROM Imiles imiles WHERE imiles.gcid = :gcid AND imiles.vin = :vin AND imiles.isLatest = :latest")
	List<?> getImilesByGCIDAndVIN(String gcid, String vin, Boolean latest);
	
}
