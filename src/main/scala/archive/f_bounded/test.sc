import models.Data
import Data._
import f_bounded.Ord._
import f_bounded.Sorter
import models.Book.SortableBook

Sorter.sort(ints.map(SortableInt))
Sorter.sort(strings.map(SortableString))
Sorter.sort(opts.map(ox => SortableOpt(ox.map(SortableInt))))

Sorter.sort(pairs.map { case (x, y) =>
  SortablePair(SortableInt(y), SortableString(x)) }) foreach println

Sorter.sort(pairedOpts.map { case (ox, oy) =>
  SortablePair(SortableOpt(ox.map(SortableString)), SortableOpt(oy.map(SortableInt))) }) foreach println

Sorter.sort(books.map(SortableBook)) foreach println

Sorter.sortBy(books)(x => SortableDouble(x.basePrice)) foreach println

