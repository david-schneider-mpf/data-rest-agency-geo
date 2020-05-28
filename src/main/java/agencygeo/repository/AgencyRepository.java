package agencygeo.repository;

import agencygeo.model.Agency;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AgencyRepository extends PagingAndSortingRepository<Agency, Long> {

}