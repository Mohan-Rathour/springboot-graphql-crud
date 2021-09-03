/**
 * 
 */
package springgraphql.javarnd_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springgraphql.javarnd_crud.models.Tutorial;

/**
 * @author EXCELINDIA\mohanpratap.singh
 *
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
