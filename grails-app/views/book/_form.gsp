<%@ page import="library.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="book.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="150" required="" value="${bookInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'genre', 'error')} required">
	<label for="genre">
		<g:message code="book.genre.label" default="Genre" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="genre" from="${bookInstance.constraints.genre.inList}" required="" value="${bookInstance?.genre}" valueMessagePrefix="book.genre"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'releaseDate', 'error')} required">
	<label for="releaseDate">
		<g:message code="book.releaseDate.label" default="Release Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="releaseDate" precision="day"  value="${bookInstance?.releaseDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="book.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${library.Author.list()}" optionKey="id" required="" value="${bookInstance?.author?.id}" class="many-to-one"/>

</div>

