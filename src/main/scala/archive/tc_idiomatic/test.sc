import models.{Data, Reversed}
import Data._
import models.Reversed
import tc_idiomatic.Sorter

Sorter.sort(ints)
Sorter.sort(strings)
Sorter.sort(opts)

Sorter.sort(pairs) foreach println
Sorter.sort(pairedOpts) foreach println
Sorter.sort(books) foreach println
Sorter.sortBy(books)(b => (Reversed(b.basePrice), b.title)) foreach println


