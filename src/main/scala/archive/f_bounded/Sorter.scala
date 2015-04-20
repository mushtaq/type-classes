package f_bounded

object Sorter {

  def sortBy[S, T <: Ord[T]](xs: List[S])(f: S => T): List[S] = xs match {
    case Nil          => Nil
    case head :: tail => insertBy(head, sortBy(tail)(f), f)
  }

  private def insertBy[S, T <: Ord[T]](x: S, xs: List[S], f: S => T): List[S] = xs match {
    case Nil                                   => List(x)
    case head :: tail if f(x).compare(f(head)) => x :: xs
    case head :: tail                          => head :: insertBy(x, tail, f)
  }


  def sort[T <: Ord[T]](xs: List[T]): List[T] = xs match {
    case Nil          => Nil
    case head :: tail => insert(head, sort(tail))
  }

  private def insert[T <: Ord[T]](x: T, xs: List[T]): List[T] = xs match {
    case Nil                             => List(x)
    case head :: tail if x.compare(head) => x :: xs
    case head :: tail                    => head :: insert(x, tail)
  }
}
