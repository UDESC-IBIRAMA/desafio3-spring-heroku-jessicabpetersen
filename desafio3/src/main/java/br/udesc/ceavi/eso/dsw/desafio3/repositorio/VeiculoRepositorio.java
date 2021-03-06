/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.eso.dsw.desafio3.repositorio;

import br.udesc.ceavi.eso.dsw.desafio3.model.Veiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jéssica Petersen
 */
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long>{

    public Veiculo findOne(Long id);

    public Veiculo findOne(Veiculo veiculo);

    public void delete(Long id);

    public List<Veiculo> findAll(String tipo, String montadora, int km);

    public List<Veiculo> findAll(String tipo);
    
    
}
