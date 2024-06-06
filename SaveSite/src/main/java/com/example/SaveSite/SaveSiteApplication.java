package com.example.SaveSite;

import com.example.SaveSite.Entity.Group;
import com.example.SaveSite.Entity.Tag;
import com.example.SaveSite.Entity.User;
import com.example.SaveSite.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class
SaveSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaveSiteApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private TagService tagService;

	@Autowired
	private NoteService noteService;

	@Autowired
	private GroupService groupService;

	@Autowired
	private BookmarkService bookmarkService;

	@Bean
	public CommandLineRunner initialization() {
		return args -> {
			System.out.println("Hello World");


			User user = userService.findUserByLogin("teste00");
			Tag tag1 =tagService.findUserByLabel("Filmes");
			Tag tag2 =tagService.findUserByLabel("Tecnologia");

			List<Tag> listTag = new ArrayList<>();
			listTag.add(tag1);
			listTag.add(tag2);

			Group group = groupService.findUserByTitle("filmes e tecnologia");

			bookmarkService.save("teste2","https://www.example.com/","","bom pra ver avaliações","pendente", listTag,group,user);


/*
			userService.save("Pedro", "1234","123");

			User user = userService.findUserByLogin("Pedro");

			tagService.save("Filmes", "#9033", user);

			tagService.save("Tecnologia", "#2243", user);

			Tag tag1 =tagService.findUserByLabel("Filmes");
			Tag tag2 =tagService.findUserByLabel("Tecnologia");

			List<Tag> listTag = new ArrayList<>();
			listTag.add(tag1);
			listTag.add(tag2);

			groupService.save("filmes e tecnologia", "",listTag,user);

			Group group = groupService.findUserByTitle("filmes e tecnologia");

			bookmarkService.save("IMDB","imdb.com","","bom pra ver avaliações","pendente", listTag,group,user);
			bookmarkService.save("BRASIL cu_de","www.brasilcode.com.br","","bom pra ver codigos","pendente", listTag,group,user);


			Bookmark bookmark = bookmarkService.findUserByLogin("IMDB");
			Bookmark bookmark2 = bookmarkService.findUserByLogin("BRASIL cu_de");

			noteService.save(bookmark.getBookmark_id(),"so assito filmes quando tem avaliações de 7 ou superior","cabou a criatividade", user);
			noteService.save(bookmark2.getBookmark_id(),"Roubar codigos é legal, nada se cria o negocio é copiar","Faz o L", user);

			userService.updateUser("6659263d58f39e398dcf3f79","","bla@gmail.com","");

			tagService.updateTag("6659263d58f39e398dcf3f7a","","blue");

 */
		};
	}
}
