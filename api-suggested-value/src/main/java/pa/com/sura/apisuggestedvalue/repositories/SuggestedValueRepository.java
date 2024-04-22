package pa.com.sura.apisuggestedvalue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.com.sura.apisuggestedvalue.models.entity.SuggestedValue;

@Repository
public interface SuggestedValueRepository extends JpaRepository<SuggestedValue, Long> {
}
