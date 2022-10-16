package com.credibanco.assessment.card.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.credibanco.assessment.card.dto.RespuestaDTO;
import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.dto.TitularDTO;

@FeignClient(name = "tarjetas", url = "${titulares.api.url}")
public interface TarjetaApiClient {

	@GetMapping(value = "/tarjetas/tarjeta")
	public @ResponseBody ResponseEntity<?> retornoBusquedaTarjeta();

	@PostMapping(value = "/tarjetas")
	public @ResponseBody ResponseEntity<RespuestaDTO<TarjetaDTO>> crearTarjeta(@RequestBody TitularDTO titular);

}
