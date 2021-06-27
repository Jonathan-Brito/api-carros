package com.brito.carro.service;

import com.brito.carro.domain.Carro;
import com.brito.carro.domain.exception.objectNotFoundException;
import com.brito.carro.dto.CarroDTO;
import com.brito.carro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    protected CarroRepository carroRepository;

    public List<CarroDTO> getCarros(){
        List<CarroDTO> list = carroRepository.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());

         return list;

    }

    public CarroDTO getCarroById(Long id){
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.map(CarroDTO::create).orElseThrow(() -> new objectNotFoundException("Carro não encontrado"));

    }

    public List<CarroDTO> getCarrosByTipo(String tipo){

        return carroRepository.findByTipo(tipo).stream().map(CarroDTO::create)
                .collect(Collectors.toList());

    }

    public CarroDTO insert(Carro carro){
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");

        return CarroDTO.create(carroRepository.save(carro));
    }

    public CarroDTO update(Carro carro, Long id){
        Assert.notNull(id, "Não foi possível atualizar o registro");

        //Busaca o carro no banco de dados
        Optional<Carro> optional = carroRepository.findById(id);

        if (optional.isPresent()){
            Carro db = optional.get();

            //Copia as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            //Atualiza o carro
            carroRepository.save(db);

            return CarroDTO.create(db);
        }
        else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }
    
    public void delete(Long id){

        carroRepository.deleteById(id);

        }
    }

    /*public List<Carro> getCarrosFake(){

        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "Brasilia amarela"));
        carros.add(new Carro(3L, "Chevette"));

        return carros;
    }*/

