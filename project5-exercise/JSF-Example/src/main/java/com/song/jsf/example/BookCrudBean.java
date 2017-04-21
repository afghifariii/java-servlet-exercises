package com.song.jsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class BookCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Book> bookList;
	private Book item = new Book();
	private Book beforeEdit = null;
	private boolean edit;
	private boolean isbnEmpty = false;
	private boolean titleEmpty = false;
	private boolean priceEmpty = false;

	@PostConstruct
	public void init() {
		bookList = new ArrayList<Book>();
	}

	public boolean check() {
		boolean flag = true;
		if (item.getIsbn().equals("")) {
			setIsbnEmpty(true);
			flag = false;
		} else {
			setIsbnEmpty(false);
		}
		if (item.getTitle().equals("")) {
			setTitleEmpty(true);
			flag = false;
		} else {
			setTitleEmpty(false);
		}
		if (item.getPrice() == 0) {
			setPriceEmpty(true);
			flag = false;
		} else {
			setPriceEmpty(false);
		}

		return flag;
	}

	public void add() {
		if (check()) {
			item.setId(bookList.isEmpty() ? 1 : bookList.get(bookList.size() - 1).getId() + 1);
			bookList.add(item);
			item = new Book();
		}

	}

	public void resetAdd() {
		item = new Book();
	}

	public void edit(Book item) {

		beforeEdit = item.clone();
		this.item = item;
		edit = true;

	}

	public void cancelEdit() {
		this.item.restore(beforeEdit);
		this.item = new Book();
		edit = false;
	}

	public void saveEdit() {
		// DAO save the edit
		if(check()){
			this.item = new Book();
			edit = false;
		}	
	}

	public void delete(Book item) throws IOException {
		// DAO save the delete
		bookList.remove(item);
	}

	public List<Book> getList() {
		return bookList;
	}

	public Book getItem() {
		return this.item;
	}

	public boolean isEdit() {
		return this.edit;
	}

	public boolean isIsbnEmpty() {
		return isbnEmpty;
	}

	public void setIsbnEmpty(boolean isbnEmpty) {
		this.isbnEmpty = isbnEmpty;
	}

	public boolean isTitleEmpty() {
		return titleEmpty;
	}

	public void setTitleEmpty(boolean titleEmpty) {
		this.titleEmpty = titleEmpty;
	}

	public boolean isPriceEmpty() {
		return priceEmpty;
	}

	public void setPriceEmpty(boolean priceEmpty) {
		this.priceEmpty = priceEmpty;
	}

}
