package pwl.models

case class Book(
  author: String,
  title: String,
  basePrice: Double,
  isImported: Boolean
)

object Book {

  implicit val bookOrd = new pwl.typeclasses.Ord[Book] {
    def compare(a: Book, b: Book) = a.basePrice < b.basePrice
  }

  implicit val bookOrd2 = new pwl.tc_idiomatic.Ord[Book] {
    def compare(a: Book, b: Book) = a.basePrice < b.basePrice
  }

}

case class Reversed[T](x: T)

object Reversed {

}
