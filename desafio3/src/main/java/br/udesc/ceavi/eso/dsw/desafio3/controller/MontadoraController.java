
package trabalho2.veiculos;

import Model.Montadora;
import Model.MontadoraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jéssica Petersen
 */

@RestController
@RequestMapping("/montadoras")
public class MontadoraResource {

    @Autowired
    private MontadoraRepositorio montadoras = new MontadoraRepositorio();

    @PostMapping
    public Montadora adicionarMontadora(@RequestBody Montadora montadora){
        return montadoras.save(montadora);
    }

    @PutMapping
    public Montadora editarMontadora(@RequestBody Montadora montadora){
        return montadoras.save(montadora);
    }

    @DeleteMapping("/{id}")
    public void deletarMontadora(@PathVariable Long id) {
        montadoras.deleteById(id);
    }
}