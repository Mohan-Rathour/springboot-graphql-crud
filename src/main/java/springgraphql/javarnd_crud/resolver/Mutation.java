/**
 * 
 */
package springgraphql.javarnd_crud.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import javassist.NotFoundException;
import springgraphql.javarnd_crud.models.Author;
import springgraphql.javarnd_crud.models.Tutorial;
import springgraphql.javarnd_crud.repository.AuthorRepository;
import springgraphql.javarnd_crud.repository.TutorialRepository;

/**
 * @author EXCELINDIA\mohanpratap.singh
 *
 */
@Component
public class Mutation implements GraphQLMutationResolver {

	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;
	
	
	@Autowired
	public Mutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
		
	}
	
	public Author createAuthor(String name, Integer age, String email) {
		Author author = new Author();
		author.setName(name);
		author.setAge(age);
		author.setEmail(email);
		
		authorRepository.save(author);
		return author;
		
	}
	
	
	public Tutorial createTutorial(String title, String description, Long authorId) {
		Tutorial tutorial = new Tutorial();
		tutorial.setTitle(title);
		tutorial.setDescription(description);
		tutorial.setAuthor(new Author(authorId));
		
		tutorialRepository.save(tutorial);
		return tutorial;
		
	}
	
	public Tutorial updateTutorial(Long id, String title, String description) throws NotFoundException {
		Optional<Tutorial> OptionalTutorial = tutorialRepository.findById(id);
		if(OptionalTutorial.isPresent()) {
			Tutorial tutorial = OptionalTutorial.get();
			
			tutorial.setTitle(title);
			tutorial.setDescription(description);
			
			tutorialRepository.save(tutorial);
			return tutorial;
			
		}
		throw new NotFoundException("Tutorial data does not exist");
		
	}
	
	public Boolean deleteTutorial(Long id) {
		tutorialRepository.deleteById(id);
		return true;
	}
}
