package Business.Objects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Allan.Amaral
 */
@Entity
@Table(name = "caminhao_lixeira")
public class CaminhaoLixeira implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_CAMINHAO_LIXEIRA")
    private Integer idCaminhaoLixeira;

    @ManyToOne
    @JoinColumn(name="ID_CAMINHAO")
    private Caminhao caminhao;

    @ManyToOne
    @JoinColumn(name="ID_LIXEIRA")
    private Lixeira lixeira;

    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    public CaminhaoLixeira() {
    }

    public CaminhaoLixeira(Caminhao caminhao, Lixeira lixeira, Date dataHora) {
        this.caminhao = caminhao;
        this.lixeira = lixeira;
        this.dataHora = dataHora;
    }
    
    public Integer getIdCaminhaoLixeira() {
        return idCaminhaoLixeira;
    }

    public void setIdCaminhaoLixeira(Integer idCaminhaoLixeira) {
        this.idCaminhaoLixeira = idCaminhaoLixeira;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public Lixeira getLixeira() {
        return lixeira;
    }

    public void setLixeira(Lixeira lixeira) {
        this.lixeira = lixeira;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Objetos.CaminhaoLixeira[ idCaminhaoLixeira=" + idCaminhaoLixeira + " ]";
    }

}
