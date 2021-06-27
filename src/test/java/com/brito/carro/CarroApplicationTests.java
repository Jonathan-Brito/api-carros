/*package com.brito.carro;

import com.brito.carro.domain.Carro;
import com.brito.carro.dto.CarroDTO;
import com.brito.carro.service.CarroService;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;



@SpringBootTest
class CarroApplicationTests {

	@Autowired
	private CarroService carroService;

	@Test
	public void testSave(){
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("esportivos");

		//Inserindo novo carro
		CarroDTO c = carroService.insert(carro);

		assertNotNull(c); // Verificando se foi inserido

		// Verificando se possui um Id
		Long id = c.getId();
		assertNotNull(id);
		
		// Buscar o objeto
		c = carroService.getCarroById(id);
		assertNotNull(c);


		//Compara o nome e o tipo
		assertEquals("Ferrari", c.getNome());
		assertEquals("esportivo", c.getTipo());

		//Deletar o objeto
		carroService.delete(id);

		//Verificar se deletou
		try {
			assertNotNull(carroService.getCarroById(id));
			fail("O carro não foi excluído");
		}
		catch (ObjectNotFoundException exception){
			// OK
		}


	}

	@Test
	public void testLista(){

		List<CarroDTO> carros = carroService.getCarros();

		assertEquals(30, carros.size());
	}

	@Test
	public void testListaPorTipo() {

		assertEquals(10, carroService.getCarrosByTipo("classicos").size());
		assertEquals(10, carroService.getCarrosByTipo("esportivos").size());
		assertEquals(10, carroService.getCarrosByTipo("luxo").size());

		assertEquals(0, carroService.getCarrosByTipo("x").size());
	}

	@Test
	public void testGet(){

		CarroDTO c = carroService.getCarroById(11L);

		assertNotNull(c);

		assertEquals("Ferrari FF", c.getNome());
	}


}
*/