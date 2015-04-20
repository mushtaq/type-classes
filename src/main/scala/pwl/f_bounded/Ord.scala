package pwl.f_bounded

trait Ord[T] {
  def compare(other: T): Boolean
}

object Ord {
  case class SortablesInt(x: Int) extends Ord[SortablesInt] {
    def compare(other: SortablesInt) = x < other.x
  }

  case class SortablesDouble(x: Double) extends Ord[SortablesDouble] {
    def compare(other: SortablesDouble) = x < other.x
  }
}
