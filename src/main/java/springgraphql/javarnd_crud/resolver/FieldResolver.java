/**
 * 
 */
package springgraphql.javarnd_crud.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import springgraphql.javarnd_crud.models.Author;
import springgraphql.javarnd_crud.models.Tutorial;
import springgraphql.javarnd_crud.repository.AuthorRepository;

/**
 * @author EXCELINDIA\mohanpratap.singh
 *
 */

@Component
public class FieldResolver implements GraphQLResolver<Tutorial> {
	
	private AuthorRepository authorRepository;
	
	@Autowired
	public FieldResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public Author getAuthor(Tutorial tutorial) {
		return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
	}
	
	
	
}
