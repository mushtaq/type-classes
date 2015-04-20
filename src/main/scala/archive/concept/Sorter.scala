package concept

object Sorter {

  def sortBy[S, T](xs: List[S])(f: S => T)(ord: Ord[T]): List[S] = xs match {
    case Nil          => Nil
    case head :: tail => insertBy(head, sortBy(tail)(f)(ord), f)(ord)
  }

  private def insertBy[S, T](x: S, xs: List[S], f: S => T)(ord: Ord[T]): List[S] = xs match {
    case Nil                                   => List(x)
    case head :: tail if ord.compare(f(x), f(head)) => x :: xs
    case head :: tail                          => head :: insertBy(x, tail, f)(ord)
  }


  def sort[T](xs: List[T])(ord: Ord[T]): List[T] = xs match {
    case Nil          => Nil
    case head :: tail => insert(head, sort(tail)(ord))(ord)
  }

  private def insert[T](x: T, xs: List[T])(ord: Ord[T]): List[T] = xs match {
    case Nil                             => List(x)
    case head :: tail if ord.compare(x, head) => x :: xs
    case head :: tail                    => head :: insert(x, tail)(ord)
  }
}
