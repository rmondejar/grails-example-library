package library

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Book)
class BookSpec extends Specification   {
    
    def "find book by title"() {
          setup:
          mockDomain(Book)
          mockDomain(Author)

          when:
          new Book(title: title,genre:genre,releaseDate:releaseDate,author:new Author(name:"John",surname:"Doe").save()).save()

          then:
          Book.findByTitle(title) != null

          where:
          title = "Nice book"
          genre  = Book.genres[0]
          releaseDate = new Date()
   }

  def "title not longer than 150 characters"() {
          setup:
          mockForConstraintsTests(Book)
          mockDomain(Author)

          when:
          def book =new Book(title:title, genre:genre,releaseDate:releaseDate,author:new Author(name:"John",surname:"Doe").save())
          book.validate()

          then:
          book.errors.hasFieldErrors("title")

          where:
          title="123456789012345678901234567890123456789011234567890123456789012345678901234567890112345678901234567890123456789012345678901123456789012345678901234567890123456789011234567890123456789012345678901234567890112345678901234567890123456789012345678901123456789012345678901234567890123456789011234567890123456789012345678901234567890112345678901234567890123456789012345678901123456789012345678901234567890123456789011234567890123456789012345678901234567890112345678901234567890123456789012345678901123456789012345678901234567890123456789011234567890123456789012345678901234567890112345678901234567890123456789012345678901"
          genre  = Book.genres[0]
          releaseDate = new Date()
   }

  def "title not blank"() {
          setup:
          mockForConstraintsTests(Book)
          mockDomain(Author)

          when:
          def book =new Book(title:title, genre:genre,releaseDate:releaseDate,author:new Author(name:"John",surname:"Doe").save())
          book.validate()

          then:
          book.errors.hasFieldErrors("title")

          where:
          title=""
          genre  = Book.genres[0]
          releaseDate = new Date()
   }

  def "author not blank"() {
          setup:
          mockForConstraintsTests(Book)
          mockDomain(Author)

          when:
          def book =new Book(title:"nice title", genre:Book.genres[0],releaseDate:new Date(),author:null)
          book.validate()

          then:
          book.errors.hasFieldErrors("author")

   }

   
}
