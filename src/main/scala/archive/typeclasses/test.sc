import models.Data
import Data._
import typeclasses.Sorter

Sorter.sort(ints)
Sorter.sort(strings)
Sorter.sort(opts)

Sorter.sort(pairs) foreach println

Sorter.sort(pairedOpts) foreach println

Sorter.sort(books) foreach println

Sorter.sortBy(books)(_.basePrice) foreach println
