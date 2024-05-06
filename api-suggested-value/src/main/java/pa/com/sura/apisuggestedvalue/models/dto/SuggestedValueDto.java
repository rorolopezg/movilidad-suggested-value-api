package pa.com.sura.apisuggestedvalue.models.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuggestedValueDto implements Serializable{
  private String currentYear;
  private double suggestedValue; 
}
