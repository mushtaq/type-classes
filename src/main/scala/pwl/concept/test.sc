import pwl.concept.{Ord, Sorter}
import pwl.models.Data._

Sorter.sort(ints)(Ord.intOrd)
Sorter.sort(strings)(Ord.strOrd)
Sorter.sort(opts)(Ord.optOrd(Ord.intOrd))
Sorter.sort(pairs)(Ord.pairOrd(Ord.strOrd, Ord.intOrd))
Sorter.sort(pairedOpts)(
  Ord.pairOrd(Ord.optOrd(Ord.intOrd), Ord.optOrd(Ord.strOrd))
)

Sorter.sortBy(books)(_.basePrice)(Ord.doubleOrd) foreach println
