package com.brito.carro.api.controller;

import com.brito.carro.domain.Carro;
import com.brito.carro.dto.CarroDTO;
import com.brito.carro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("api/v1/carros")
public class CarroController implements CarroControllerDocs {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity get(){
        List<CarroDTO> carros = carroService.getCarros();

        return ResponseEntity.ok(carros);

    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        CarroDTO c = carroService.getCarroById(id);

        return ResponseEntity.ok(c);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo){
        List<CarroDTO> carros = carroService.getCarrosByTipo(tipo);

        return carros.isEmpty() ?   // Se está vazio
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);

    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity post(@RequestBody Carro carro){

        CarroDTO carroDTO = carroService.insert(carro); // Carro que foi inserido

        URI location = getUri(carroDTO.getId());
        return ResponseEntity.created(location).build();
    }

    private URI getUri(Long id){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro){

        carro.setId(id);

        CarroDTO carroDTO = carroService.update(carro, id);

        return carroDTO != null ?
                    ResponseEntity.ok(carroDTO) :
                    ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        carroService.delete(id);

        return ResponseEntity.ok().build();

    }

}
