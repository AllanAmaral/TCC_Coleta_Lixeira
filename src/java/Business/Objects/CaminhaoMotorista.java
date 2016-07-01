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
@Table(name = "caminhao_motorista")
public class CaminhaoMotorista implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_CAMINHAO_MOTORISTA")
    private Integer idCaminhaoMotorista;

    @ManyToOne
    @JoinColumn(name="ID_CAMINHAO")
    private Caminhao caminhao;

    @ManyToOne
    @JoinColumn(name="ID_MOTORISTA")
    private Motorista motorista;

    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    public CaminhaoMotorista() {
    }

    public CaminhaoMotorista(Caminhao caminhao, Motorista motorista, Date dataHora) {
        this.caminhao = caminhao;
        this.motorista = motorista;
        this.dataHora = dataHora;
    }

    public Integer getIdCaminhaoMotorista() {
        return idCaminhaoMotorista;
    }

    public void setIdCaminhaoMotorista(Integer idCaminhaoMotorista) {
        this.idCaminhaoMotorista = idCaminhaoMotorista;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Objetos.CaminhaoMotorista[ idCaminhaoMotorista=" + idCaminhaoMotorista + " ]";
    }

}
