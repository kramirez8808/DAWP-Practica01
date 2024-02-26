package dawp.practica01.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import dawp.practica01.domain.Arbol;

public interface ArbolDao extends JpaRepository<Arbol, Long>{
    
}
