package com.serpro.Masterdata.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Predicate;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serpro.Masterdata.entity.Todo;
import com.serpro.Masterdata.repository.TodoRepository;

@Service
public class TodoService {

	 @Autowired
	private TodoRepository todorepo;

	public static List<Todo> todos = new ArrayList<Todo>();
	public static List<Todo> todo1 = new ArrayList<Todo>();
	int i = 0;

	static {
		todos.add(new Todo(1, "gym", "this is a new todo for going to gym", LocalDate.now().plusYears(1),
				"Not yet started", ""));
		todos.add(new Todo(2, "planting", "this is a new todo for planting", LocalDate.now().plusYears(2),
				"Not yet started", ""));
		todos.add(new Todo(3, "Jogging", "this is a new todo for jogging", LocalDate.now().plusYears(2),
				"Not yet started", ""));
		todos.add(new Todo(4, "Learning", "this is a new todo for Learning", LocalDate.now().plusYears(2),
				"Not yet started", ""));
	}

	public List<Todo> gettodobyusername(Todo todo) {
		todos = todorepo.getall();

		System.out.println(todo);
		todorepo.findAll();
		return todos;
	}

	public void inserttodo(String username, String description, LocalDate targetdate, String status, String done) {

		todorepo.insert(++i, username, description, targetdate, status, done);

	}

	public void deletetodo(int id) {

		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		todorepo.delete(id);

	}

	public void updatetodo(long id, String username, String desc, LocalDate td, String st, String done) {

		todorepo.update(username,desc, st, td, "false", id);

	}

	public Optional<Todo> findbyid(int id) {
		return todorepo.findById(id);

	}

	public void modifyWordTemplate(String templatePath, String outputPath, Map<String, String> data) throws Exception {
		XWPFDocument document = new XWPFDocument(new FileInputStream(templatePath));

		// Iterate over the paragraphs and replace placeholders
		document.getParagraphs().forEach(paragraph -> {
			String text = paragraph.getText();
			for (Map.Entry<String, String> entry : data.entrySet()) {
				if (text.contains(entry.getKey())) {
					String text1 = text.replace(entry.getKey(), entry.getValue());
					paragraph.getRuns().forEach(run -> {
						run.setText(text1); // Update the text
					});
				}
			}
		});

		try (FileOutputStream out = new FileOutputStream(outputPath)) {
			document.write(out);
		}
	}

	public void convertWordToPdf(String wordFilePath, String pdfFilePath) throws Exception {
		// Example with Apache PDFBox (can also use iText)
		PDDocument doc = PDDocument.load(new File(wordFilePath));
		doc.save(pdfFilePath);
		doc.close();
	}

	public void sendEmailWithAttachment(String toEmail, String subject, String body, String pdfPath) {
		// SMTP properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Authentication
		String fromEmail = "compensationadvisor@outlook.com";
		String password = "your-password";

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		try {
			// Create email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(subject);

			// Create message body
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);

			// Create the attachment
			MimeBodyPart attachmentPart = new MimeBodyPart();
			attachmentPart.attachFile(pdfPath);

			// Combine message and attachment
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachmentPart);

			message.setContent(multipart);

			// Send email
			Transport.send(message);

			System.out.println("Email sent successfully with attachment.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getDataFromDatabase() {
		List<Todo> k = todorepo.findAll();
		HashMap<String, String> map = new HashMap<String,String>();
//		id=id;
//		this.username=username;
//		this.description=description;
//		this.targetdate=targetdate;
//		this.status=status;
//		this.done=string;
		
		Todo i = k.get(0);
		map.put("id",String.valueOf(i.getId()));
		map.put("username",i.getUsername());
		map.put("description",i.getDescription() );
		map.put("td",String.valueOf(i.getTargetdate()));
		map.put("status",i.getStatus());
		map.put("done",i.getDone());
		
		return map;
	}

	

}
