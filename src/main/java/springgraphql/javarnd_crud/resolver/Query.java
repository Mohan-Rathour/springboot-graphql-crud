/**
 * 
 */
package springgraphql.javarnd_crud.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import springgraphql.javarnd_crud.models.Author;
import springgraphql.javarnd_crud.models.Tutorial;
import springgraphql.javarnd_crud.repository.AuthorRepository;
import springgraphql.javarnd_crud.repository.TutorialRepository;

/**
 * @author EXCELINDIA\mohanpratap.singh
 *
 */

@Component
public class Query implements GraphQLQueryResolver {
	
	
	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;
	
	
	@Autowired
	public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
		
	}
	
	
	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
		
	}
	
	public Iterable<Tutorial> findAllTutorials() {
		return tutorialRepository.findAll();
		
	}

}
