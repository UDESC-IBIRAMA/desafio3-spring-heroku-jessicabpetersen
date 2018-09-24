/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.eso.dsw.desafio3.service;

import br.udesc.ceavi.eso.dsw.desafio3.model.Veiculo;
import br.udesc.ceavi.eso.dsw.desafio3.repositorio.VeiculoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jéssica Petersen
 */
public class VeiculoService {
    @Autowired
    VeiculoRepositorio repositorio;
    
    public Veiculo findById(Long id){
        return repositorio.findOne(id);
    }
    
    public List<Veiculo> findByTipoMontadoraKm(String tipo,String montadora,int km){
        return repositorio.findAll(tipo, montadora, km);
    }
    
    public List<Veiculo> getAll(){
        return repositorio.findAll();
    }
    
    public void create(Veiculo veiculo){
        repositorio.save(veiculo);
    }
    
    public void update(Veiculo veiculo){
        Veiculo veiculoUpdated = repositorio.findOne(veiculo);
        veiculoUpdated.setCor(veiculo.getCor());
        veiculoUpdated.setModelo(veiculo.getModelo());
        veiculoUpdated.setMontadora(veiculo.getMontadora());
        veiculoUpdated.setMotor(veiculo.getMotor());
        veiculoUpdated.setQuilometragem(veiculo.getQuilometragem());
        veiculoUpdated.setTipo(veiculo.getTipo());
        
        repositorio.save(veiculoUpdated);
    }
    
    public void delete(Long id){
        repositorio.delete(id);
    }

    public List<Veiculo> buscaVeiculosByTipo(String tipo) {
        return repositorio.findAll(tipo);
    }

    public List<Veiculo> buscarVeiculoByMontadora(String montadora) {
        return repositorio.findAll(montadora);
    }
}
