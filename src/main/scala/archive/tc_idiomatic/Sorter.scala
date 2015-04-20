package tc_idiomatic

object Sorter {

  def sortBy[S, T: Ord](xs: List[S])(f: S => T): List[S] = xs match {
    case Nil          => Nil
    case head :: tail => insertBy(head, sortBy(tail)(f), f)
  }

  private def insertBy[S, T: Ord](x: S, xs: List[S], f: S => T): List[S] = xs match {
    case Nil                                           => List(x)
    case head :: tail if Ord[T].compare(f(x), f(head)) => x :: xs
    case head :: tail                                  => head :: insertBy(x, tail, f)
  }


  def sort[T: Ord](xs: List[T]): List[T] = xs match {
    case Nil          => Nil
    case head :: tail => insert(head, sort(tail))
  }

  private def insert[T: Ord](x: T, xs: List[T]): List[T] = xs match {
    case Nil                                     => List(x)
    case head :: tail if Ord[T].compare(x, head) => x :: xs
    case head :: tail                            => head :: insert(x, tail)
  }
}
