package com.casashow.casa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casashow.casa.models.Casa;

public interface CasaRepository extends JpaRepository<Casa, String> {
	
}
