package org.formation.document.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.formation.document.model.Document;
import org.formation.document.model.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * A RESTFul controller for accessing Document information.
 * 
 * @author David Thibau from Paul Chapman
 */
@RestController
@RequestMapping("/documents-service")
public class DocumentsRestController {

	protected Logger logger = Logger.getLogger(DocumentsRestController.class
			.getName());
	protected DocumentRepository documentRepository;

	/**
	 * @param documentRepository
	 */
	@Autowired
	public DocumentsRestController(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;

		logger.info("DocumentRepository says system has "
				+ documentRepository.countDocuments() + " Documents");
	}



	/**
	 * @param owner
	 * @return
	 */
	@GetMapping("/owner/{name}/")
	public List<Document> getDocuments(@PathVariable("name") String owner) {
		logger.info("Documents-service byOwner() invoked: "
				+ documentRepository.getClass().getName() + " for "
				+ owner);

		List<Document> documents = documentRepository
				.findByOwner(owner);
		logger.info("Documents-service byOwner() found: " + documents );

		return documents;
		
	}
	
	@GetMapping()
	public List<Document> getAllDocuments() {
		logger.info("Documents-service getAll() invoked: ");

		List<Document> documents = documentRepository
				.findAll();
		logger.info("Documents-service byOwner() found: " + documents );

		return documents;
		
	}
	
	@PostMapping
	public ResponseEntity<Document> addDocumentToOwner(@Valid @RequestBody Document doc ) {
		logger.info("Documents-service Save  ");

	
		documentRepository.save(doc);
		

		return new ResponseEntity<>(doc,HttpStatus.ACCEPTED);
		
	}


}
