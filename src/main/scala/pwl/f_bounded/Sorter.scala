package pwl.f_bounded

object Sorter {

  def sortBy[S, T <: Ord[T]](xs: List[S])(f: S => T): List[S] = xs match {
    case Nil      => Nil
    case x :: xs1 => insertBy(x, sortBy(xs1)(f))(f)
  }

  def insertBy[S, T <: Ord[T]](x: S, xs: List[S])(f: S => T): List[S] = xs match {
    case Nil                                   => List(x)
    case head :: tail if f(x).compare(f(head)) => x :: xs
    case head :: tail                          => head :: insertBy(x, tail)(f)
  }

  def sort[T <: Ord[T]](xs: List[T]): List[T] = xs match {
    case Nil      => Nil
    case x :: xs1 => insert(x, sort(xs1))
  }

  def insert[T <: Ord[T]](x: T, xs: List[T]): List[T] = xs match {
    case Nil                             => List(x)
    case head :: tail if x.compare(head) => x :: xs
    case head :: tail                    => head :: insert(x, tail)
  }
}
