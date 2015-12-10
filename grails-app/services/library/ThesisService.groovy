package library

class ThesisService {

  static transactional = true

  Book createThesis(Long authorId) {

    Author authorInstance = Author.get(authorId)

    Book bookInstance = new Book(title: "My copied thesis", genre:Book.genres[0], releaseDate:new Date(), author: authorInstance).save()

    log.debug("Created thesis $bookInstance")

    bookInstance
  }

}
