package com.jnit.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String name;
	private String author;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, targetEntity = Author.class)
	@JoinTable(name = "Author_Book", joinColumns = {
			@JoinColumn(name = "bookId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "authorId", nullable = false) })
	private List<Author> authors = new ArrayList();

	public Book(){
		super();
	}
	public Book(Long bookId, String name, String author) {
		super();

		this.bookId = bookId;
		this.name = name;
		this.author = author;

	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
			this.authors = authors;
		}
}