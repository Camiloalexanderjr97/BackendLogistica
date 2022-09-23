package Backend.PlanEnvio.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Backend.PlanEnvio.Entity.PlanEnvio;

@Repository
public interface PlanEnvioRepository extends CrudRepository<PlanEnvio, Long> {
	
	
	
//	  @Transactional
//	    @Modifying
//		  @Query(value = "UPDATE departamento SET departamento.id = :idNueva , departamento.Nombre = :nombre, departamento.ProgramaAcademico = :programa WHERE departamento.id = :id",
////				  update Users u set u.status = ? where u.name = )
//		    nativeQuery = true)
//		  int updateDepartamentoSetStatusForNameNative(int id, String nombre, int programa, Long idNueva);

}
