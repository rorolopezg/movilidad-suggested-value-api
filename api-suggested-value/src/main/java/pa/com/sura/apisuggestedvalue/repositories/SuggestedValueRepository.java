package pa.com.sura.apisuggestedvalue.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.com.sura.apisuggestedvalue.models.entity.SuggestedValue;
@Repository
public interface SuggestedValueRepository extends JpaRepository<SuggestedValue, Long> {
    /*
     * Map<String, String> getSuggestedValue(@Param("ramo") String ramo,
     * 
     * @Param("original_car_value") Integer original_car_value,
     * 
     * @Param("use") String use, @Param("year") int year);
     */
}
