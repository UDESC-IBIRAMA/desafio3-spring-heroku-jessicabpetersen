package dsw.Desafio3.respositorio;

import dsw.Desafio3.model.Veiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {
	
    List<Veiculo> tiposDeVeiculo(String tipo);
    
    List<Veiculo> montadora(String montadora);
    
    List<Veiculo> motor(String motor);
    
    List<Veiculo> filtros(String tipo, String montadora, int km);


}
