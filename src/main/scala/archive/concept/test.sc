import models.{Data, Book}
import Data._
import concept.{Ord, Sorter}
import models.Book


Sorter.sort(ints)(Ord.intOrd)
Sorter.sort(strings)(Ord.stringOrd)
Sorter.sort(opts)(Ord.optOrd(Ord.intOrd))

Sorter.sort(pairs)(Ord.pairOrd(Ord.stringOrd, Ord.intOrd)) foreach println

Sorter.sort(pairedOpts)(Ord.pairOrd(Ord.optOrd(Ord.stringOrd), Ord.optOrd(Ord.intOrd))) foreach println

Sorter.sort(books)(Book.bookOrd) foreach println

Sorter.sortBy(books)(_.basePrice)(Ord.doubleOrd) foreach println

