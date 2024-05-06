package pa.com.sura.apisuggestedvalue.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pa.com.sura.apisuggestedvalue.models.dto.SuggestedValueDto;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcSuggestedValueServiceImpl implements CalcSuggestedValueService {
    @Autowired
    private EntityManager manager;

    public SuggestedValueDto getSuggestedValueDto(double suma_aseg, String uso, String ramo, int year) {

        StoredProcedureQuery query = manager.createNamedStoredProcedureQuery("getSuggestedValue");
        int currentYear = 0;
        Object suggestedValue;
        Object ok;
        Object message;
        // Map<String, String> result = new HashMap<>();
        SuggestedValueDto result = new SuggestedValueDto();
        query.setParameter("p_suma_asegurada", suma_aseg);
        query.setParameter("p_uso", uso);
        query.setParameter("p_ramo", ramo);
        query.setParameter("p_ano_automovil", year);
        query.execute();
        ok = query.getOutputParameterValue("p_ok");
        message = query.getOutputParameterValue("p_mensaje");
        suggestedValue = query.getOutputParameterValue("p_valor_sugerido");

        Calendar cal = Calendar.getInstance();
        currentYear = cal.get(Calendar.YEAR);
        if (ok == null) {
            result.setSuggestedValue(Double.parseDouble(suggestedValue.toString()));
            result.setCurrentYear(Integer.toString(currentYear));
        }
        /*
         * if (ok != null) result.put("ok", ok.toString());else result.put("ok",
         * "Not Found");
         * if (message != null) result.put("message", message.toString());else
         * result.put("message", "Not Found");
         * if (suggestedValue != null) result.put("suggestedValue",
         * suggestedValue.toString());else result.put("suggestedValue", "Not Found");
         */
        return result;
    }

}
