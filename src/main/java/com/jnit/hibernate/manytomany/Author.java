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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotBlank;



@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorId;
    private String authorName;
	private String phoneNumber;

	

	@ManyToMany(fetch = FetchType.LAZY,cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, targetEntity=Book.class)
	@JoinTable(name = "Author_Book", joinColumns = {
			@JoinColumn(name = "authorId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "bookId", nullable = false) 
	})	
	private List<Book> books = new ArrayList();

	public Author() {
		super();
	}

	public Author(String authorName,String phoneNumber) {
		super();
		//this.authorId = authorId;
		this.authorName = authorName;
		this.phoneNumber = phoneNumber;
		
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", phoneNumber=" + phoneNumber
				+ ", books=" + books + "]";
	}

}