package Business;

import Business.Objects.Lixeira;
import DAO.LixeiraRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.List;
import javax.json.Json;
import javax.json.stream.JsonGenerator;

/**
 *
 * @author Allan.Amaral
 */
public class LixeiraController {

    private final LixeiraRepository repository;
    
    public LixeiraController() {
        repository = new LixeiraRepository();
    }
    
    public void registrar(BigDecimal capacidadeLixeiraKg, BigDecimal capacidadeLixeiraLt,
            BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt,
            BigDecimal latitude, BigDecimal longitude) throws Exception {
        Lixeira lixeira = new Lixeira(capacidadeLixeiraKg, capacidadeLixeiraLt, coletadoLixeiraKg, 
                coletadoLixeiraLt, latitude, longitude);
        repository.registrar(lixeira);
    }

    public void editar(Lixeira lixeira) throws Exception {
        repository.editar(lixeira);
    }

    public void excluir(Integer id) throws Exception {
        repository.excluir(id);
    }

    public Lixeira buscarLixeira(Integer id) {
        return repository.buscarLixeira(id);
    }
    
    public void carregarPontosLixeiras() throws Exception {
        List<Lixeira> lixeiras = repository.buscarLixeiras();
        FileOutputStream fos = new FileOutputStream("C:/Users/allan.amaral/Documents/GitHub/TCC_Coleta_Lixeira/web/js/pontos.json");
        JsonGenerator geradorJson = Json.createGenerator(fos);

        geradorJson.writeStartArray();
        for (Lixeira lixeira : lixeiras) {
            // começando a escrever o objeto JSON e então as propriedades, por fim fecha o objeto
            geradorJson.writeStartObject()
                    .write("Id", lixeira.getIdLixeira())
                    .write("Latitude", lixeira.getLatitude())
                    .write("Longitude", lixeira.getLongitude())
                    .write("Capacidade Kg", lixeira.getCapacidadeLixeiraKg())
                    .write("Capacidade Lt", lixeira.getCapacidadeLixeiraLt())
                    .write("Coletado Kg", lixeira.getColetadoLixeiraKg())
                    .write("Coletado Lt", lixeira.getColetadoLixeiraLt())
                    .writeEnd();
        }

        geradorJson.writeEnd().close();
    }
    
    public void enviarStatus(BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt) {
        
    }
}
