package com.brito.carro.api.controller;

import com.brito.carro.domain.Carro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api("Carros management")
public interface CarroControllerDocs {

    @ApiOperation(value = "List all registered car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all registered car"),
    })
    ResponseEntity get();

    @ApiOperation(value = "Find Carro By car operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success car found"),
            @ApiResponse(code = 404, message = "Car not found error code")
    })
    ResponseEntity get(@PathVariable("id") Long id);

    @ApiOperation(value = "Find Carro By Tipo operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success car found"),
            @ApiResponse(code = 404, message = "Car tipo not found error code")
    })
    ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo);


    @ApiOperation(value = "Car creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success car creation"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value" +
                    "or car already registered on system")
    })
    ResponseEntity post(@RequestBody Carro carro);

    @ApiOperation(value = "Car update operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success car update"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value" +
                    "or car already registered on system")
    })
    ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro);

    @ApiOperation(value = "Car delete operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success car delete"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value" +
                    "or car already registered on system")
    })
    ResponseEntity delete(@PathVariable("id") Long id);

}
