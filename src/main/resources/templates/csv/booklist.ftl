Id;ISBN;Titel;Autor;Erscheinungsdatum
<#list books as book>
${book.id()}${sep}${book.isbn()}${sep}${book.title()}${sep}${book.author()}${sep}${book.releaseDate()?date}
</#list>