/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.eso.dsw.desafio3.controller;

import br.udesc.ceavi.eso.dsw.desafio3.model.Veiculo;
import br.udesc.ceavi.eso.dsw.desafio3.service.VeiculoService;
import java.util.List;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jéssica Petersen
 */
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoService service = new VeiculoService();
    
    @GetMapping("/Id/{id}")
    public Veiculo buscaVeiculoId(@PathParam("id") long id) {
        Veiculo veiculo = null;
        try {
            veiculo = service.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculo;
    }
    

    @GetMapping("/{tipo}/{montadora}/{km}")
    public List<Veiculo> getFiltrado(
            @PathParam("tipo") String tipo,
            @PathParam("montadora") String montadora,
            @PathParam("km") int km) {
        return service.findByTipoMontadoraKm(tipo, montadora, km);
    }

    @GetMapping("/{tipo}")
    public List<Veiculo> buscaVeiculoTipo(@PathParam("tipo") String tipo) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = service.buscaVeiculosByTipo(tipo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    @GetMapping("/{montadora}")
    public List<Veiculo> buscaVeiculoMontadora(@PathParam("montadora") String montadora) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = service.buscarVeiculoByMontadora(montadora);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }
    
   

    /**
     * PUT method for updating or creating an instance of VeiculoResource
     * @param content representation for the resource
     */
    @PutMapping("/editar")
    public void editarVeiculo(Veiculo model) {
        try {
            service.update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @PostMapping("/adicionarVeiculo")
    public void adicionarVeiculo(Veiculo model) {
        try {
            service.create(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @DeleteMapping("/{id}")
    public void deletarVeiculo(@PathParam("id") Long id) {
        try {
            service.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
