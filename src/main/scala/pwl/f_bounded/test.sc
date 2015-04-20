
import pwl.f_bounded.Ord.{SortablesDouble, SortablesInt}
import pwl.models.Data._
import pwl.f_bounded.Sorter

Sorter.sort(ints.map(SortablesInt)).map(_.x)

Sorter.sortBy(books)(x => SortablesDouble(x.basePrice)) foreach println


