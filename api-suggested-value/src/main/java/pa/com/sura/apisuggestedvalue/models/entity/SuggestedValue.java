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
@NamedStoredProcedureQuery(name = "getSuggestedValue", procedureName = "INSIS_CUST_SURA_UY.test_api_cursor", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ramo", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "original_car_value", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "use", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "year", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "current_year", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "suggested_value", type = Double.class)
})
public class SuggestedValue implements Serializable {
    @Id
    private Long id;
}