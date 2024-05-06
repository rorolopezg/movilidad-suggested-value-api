package pa.com.sura.apisuggestedvalue.services;

import pa.com.sura.apisuggestedvalue.models.dto.SuggestedValueDto;

public interface CalcSuggestedValueService {
    public SuggestedValueDto getSuggestedValueDto(double suma_aseg, String uso, String ramo, int year);
}
