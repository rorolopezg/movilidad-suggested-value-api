package pa.com.sura.apisuggestedvalue.models.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@NamedStoredProcedureQuery(name = "getSuggestedValue", procedureName = "SEGUROS.pkg_nube_seguros2.valor_sugerido_automovil", parameters = {
        //in parameters        
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_suma_asegurada", type = Double.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_uso", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ramo", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ano_automovil", type = Integer.class),
       //out parameters
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ok", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_mensaje", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_valor_sugerido", type = Double.class)
})
public class SuggestedValue implements Serializable {
    @Id
    private Long id;
}