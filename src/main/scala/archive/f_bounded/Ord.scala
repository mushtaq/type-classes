package f_bounded

trait Ord[T <: Ord[T]] {
  def compare(other: T): Boolean
}

object Ord {
  case class SortableInt(int: Int) extends Ord[SortableInt] {
    def compare(other: SortableInt) = int < other.int
  }

  case class SortableDouble(double: Double) extends Ord[SortableDouble] {
    def compare(other: SortableDouble) = double < other.double
  }

  case class SortableString(string: String) extends Ord[SortableString] {
    def compare(other: SortableString) = string < other.string
  }

  case class SortableOpt[T <: Ord[T]](option: Option[T]) extends Ord[SortableOpt[T]] {
    def compare(other: SortableOpt[T]) = (option, other.option) match {
      case (Some(x), Some(y)) => x.compare(y)
      case (None, Some(_))    => true
      case (_, _)             => false
    }
  }

  case class SortablePair[T1 <: Ord[T1], T2 <: Ord[T2]](x: T1, y: T2) extends Ord[SortablePair[T1, T2]] {
    def compare(other: SortablePair[T1, T2]) =
      if (x.compare(other.x)) true
      else if (other.x.compare(x)) false
      else y.compare(other.y)
  }
}
