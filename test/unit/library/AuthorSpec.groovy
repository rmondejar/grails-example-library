package library

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Author)
class AuthorSpec extends Specification {


  def "find author by name and surname"() {
    setup:
    mockDomain(Author)

    when:
    new Author(name: name, surname: surname).save()

    then:
    Author.findByNameAndSurname(name, surname) != null

    where:
    name = "John"
    surname = "Doe"
  }

  def "name constraints"() {
    setup:
    mockForConstraintsTests(Author)

    when:
    def author = new Author(surname: "Doe")
    author.name = name
    author.validate()

    then:
    author.hasErrors() == !valid

    where:

    name | valid
    "12345678901234567890012345678901" | false //name must not have more than 30 characters
    "12345678901234567890" | true
    "" | false //name must not be blank

  }

  def "surname constraints"() {
    setup:
    mockForConstraintsTests(Author)

    when:
    def author = new Author(name: "John")
    author.surname = surname
    author.validate()

    then:
    author.hasErrors() == !valid

    where:
    surname | valid
    "1234567890123456789012345678901234567890123456789012345678901" | false
    "12345678901234567890" | true
    "" | false
  }

}
