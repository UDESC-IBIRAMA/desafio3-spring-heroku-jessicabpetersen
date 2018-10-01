package dsw.Desafio3.Controller;

import java.util.Optional;
import javax.validation.Valid;
//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import dsw.Desafio3.model.Veiculo;
import dsw.Desafio3.respositorio.VeiculoRepositorio;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResources {

    @Autowired
    private VeiculoRepositorio repositorio;

    @GetMapping(value = "/veiculos")
    public @ResponseBody
    Iterable<Veiculo> getVeiculos() {
        Iterable<Veiculo> listaVeiculos = repositorio.findAll();
        return listaVeiculos;
    }

    @GetMapping(value = "/{id}")
    public Veiculo buscaId(@PathVariable Long id) throws Exception {
        Optional<Veiculo> verifica = repositorio.findById(id);
        if (!verifica.isPresent()) {
            throw new Exception("Id - " + id + " Inexistente!");
        }
        return verifica.get();
    }
    
    @GetMapping(value = "/filtros/{tipo}/{montadora}/{km}")
    public @ResponseBody
    Iterable<Veiculo> filtros(@PathVariable String tipo, @PathVariable String montadora, @PathVariable int km) {
        Iterable<Veiculo> listaVeiculos = repositorio.filtros(tipo, montadora, km);
        return listaVeiculos;
    }

    @GetMapping(value = "/{tipo}")
    public @ResponseBody
    Iterable<Veiculo> getByTipo(@PathVariable String tipo) {
        Iterable<Veiculo> listaVeiculos = repositorio.tiposDeVeiculo(tipo);
        return listaVeiculos;
    }

    @GetMapping(value = "/montadora}")
    public @ResponseBody
    Iterable<Veiculo> getByMontadora(@PathVariable String montadora) {
        Iterable<Veiculo> listaVeiculos = repositorio.montadora(montadora);
        return listaVeiculos;
    }

    @GetMapping(value = "/{motor}")
    public @ResponseBody
    Iterable<Veiculo> getByMotor(@PathVariable String motor) {
        Iterable<Veiculo> listaVeiculos = repositorio.motor(motor);
        return listaVeiculos;
    }


    @PostMapping(value = "/cadastro")
    public Veiculo cadastrarVeiculo(@RequestBody @Valid Veiculo model) {
        return repositorio.save(model);
    }

    @PutMapping(value = "/alterar/{id}")
    public ResponseEntity<Veiculo> alterarVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo model) {
        Optional<Veiculo> achado = repositorio.findById(id);

        if (achado.isPresent()) {
            Veiculo veiculo = achado.get();
            veiculo.setId(model.getId());
            veiculo.setMontadora(model.getMontadora());
            veiculo.setModelo(model.getModelo());
            veiculo.setCor(model.getCor());
            veiculo.setKm(model.getKm());
            veiculo.setMotor(model.getMotor());
            veiculo.setTipo(model.getTipo());

            repositorio.save(veiculo);
            return ResponseEntity.ok(veiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/deleta/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        Veiculo existe = repositorio.getOne(id);
        if (existe == null) {
            return ResponseEntity.notFound().build();
        } else {
            repositorio.delete(existe);
        }
        return ResponseEntity.noContent().build();
    }

}
