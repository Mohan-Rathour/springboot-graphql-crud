/**
 * 
 */
package springgraphql.javarnd_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springgraphql.javarnd_crud.models.Author;

/**
 * @author EXCELINDIA\mohanpratap.singh
 *
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
