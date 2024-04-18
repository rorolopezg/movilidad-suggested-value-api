package pa.com.sura.apisuggestedvalue.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcSuggestedValueServiceImpl implements CalcSuggestedValueService {
    @Autowired
    private EntityManager manager;

    public Map<String, String> getSuggestedValueDto(String ramo, double originalCarValue, String use, int year) {

        StoredProcedureQuery query = manager.createNamedStoredProcedureQuery("getSuggestedValue");
        String currentYear = "No found";
        String suggestedValue = "No found";
        query.setParameter("ramo", ramo);
        query.setParameter("original_car_value", originalCarValue);
        query.setParameter("use", use);
        query.setParameter("year", year);
        query.execute();
        currentYear = query.getOutputParameterValue("current_year").toString();
        suggestedValue = query.getOutputParameterValue("suggested_value").toString();
        Map<String, String> result = new HashMap<>();
        result.put("currentYear", currentYear);
        result.put("suggestedValue", suggestedValue);
        return result;
    }

}
