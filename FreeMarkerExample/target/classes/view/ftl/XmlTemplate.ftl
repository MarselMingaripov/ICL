<Books>
	<Message>List of books</Message>
    <#list books as book>
		<Book>
			<Name>${book.name}</Name>
			<Author>${book.author}</Author>
		</Book>
	</#list>
</Books>