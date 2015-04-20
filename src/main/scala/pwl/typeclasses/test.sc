import pwl.models.Data._
import pwl.typeclasses.{Ord, Sorter}
import Ord._

object A {
  implicit val strOrd = new Ord[String] {
    def compare(a: String, b: String) = a > b
  }
}

Sorter.sort(ints)
Sorter.sort(strings)(A.strOrd)
Sorter.sort(opts)
Sorter.sort(pairs)


Sorter.sort(pairedOpts) foreach println

{
  import A.strOrd
  Sorter.sort(pairedOpts) foreach println
}


Sorter.sortBy(books)(_.basePrice) foreach println
Sorter.sort(books) foreach println



