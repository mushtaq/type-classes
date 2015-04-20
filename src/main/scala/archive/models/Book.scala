package models

case class Book(
  author: String,
  title: String,
  basePrice: Double,
  isImported: Boolean
)

object Book {
  case class SortableBook(book: Book) extends f_bounded.Ord[SortableBook] {
    def compare(other: SortableBook) = book.basePrice < other.book.basePrice
  }

  val bookOrd = new concept.Ord[Book] {
    def compare(a: Book, b: Book) = a.basePrice < b.basePrice
  }

  implicit val bookOrd2 = new typeclasses.Ord[Book] {
    def compare(a: Book, b: Book) = a.basePrice < b.basePrice
  }

  implicit val bookOrd3 = new tc_idiomatic.Ord[Book] {
    def compare(a: Book, b: Book) = a.basePrice < b.basePrice
  }
}

case class Reversed[T](x: T)

object Reversed {
  import tc_idiomatic.Ord
  implicit def revOrd[T: Ord]: Ord[Reversed[T]] = new Ord[Reversed[T]] {
    def compare(a: Reversed[T], b: Reversed[T]) = Ord[T].compare(b.x, a.x)
  }
}
