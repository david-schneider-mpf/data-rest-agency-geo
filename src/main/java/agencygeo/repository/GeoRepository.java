package agencygeo.repository;

import agencygeo.model.Geo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeoRepository extends PagingAndSortingRepository<Geo, Long> {

}