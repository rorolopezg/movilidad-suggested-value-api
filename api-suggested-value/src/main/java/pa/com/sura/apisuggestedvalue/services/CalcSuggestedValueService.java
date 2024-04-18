package pa.com.sura.apisuggestedvalue.services;
import java.util.Map;

public interface CalcSuggestedValueService {
    public Map<String,String> getSuggestedValueDto(String ramo, double originalCarValue, String use, int Year);

}
