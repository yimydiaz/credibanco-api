package com.credibanco.assessment.card.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.api.client.TarjetaApiClient;
import com.credibanco.assessment.card.dto.RespuestaDTO;
import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.dto.TitularDTO;

@CrossOrigin
@RestController
@RequestMapping("api/tarjeta")
public class TarjetaController {

	@Autowired
	private TarjetaApiClient tarjetaApiClient;

	@GetMapping("tarjetas")
	public ResponseEntity<?> retornoBusquedaTarjeta() {
		LinkedHashMap<?, ?> respuestaDTO = (LinkedHashMap<?, ?>) tarjetaApiClient.retornoBusquedaTarjeta().getBody();
		return new ResponseEntity<>(respuestaDTO, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<RespuestaDTO<TarjetaDTO>> crearTitular(@RequestBody TitularDTO tarjeta) {
		return tarjetaApiClient.crearTarjeta(tarjeta);
	}

}
