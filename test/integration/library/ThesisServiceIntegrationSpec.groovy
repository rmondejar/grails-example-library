package library

import grails.test.spock.IntegrationSpec

class ThesisServiceIntegrationSpec extends IntegrationSpec {

  def thesisService

  def "Create thesis for first author in DB"() {

    when:
    def thesis = thesisService.createThesis(authorId)

    then:
    thesis != null
    Book.countByAuthor(author) == 7

    where:
    authorId = 1L
    author = Author.get(authorId)
  }
}
