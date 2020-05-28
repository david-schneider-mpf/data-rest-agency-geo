package agencygeo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agency")
public @Data
class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "agency_geo",
            joinColumns = @JoinColumn(name = "agency_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "geo_id",
                    referencedColumnName = "id"))
    private List<Geo> geos;

}