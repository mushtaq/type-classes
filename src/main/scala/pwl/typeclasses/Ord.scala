package pwl.typeclasses

trait Ord[T] {
  def compare(a: T, b: T): Boolean
}

object Ord {

  implicit val intOrd = new Ord[Int] {
    def compare(a: Int, b: Int) = a < b
  }

  implicit val doubleOrd = new Ord[Double] {
    def compare(a: Double, b: Double) = a < b
  }

  implicit val strOrd = new Ord[String] {
    def compare(a: String, b: String) = a < b
  }

  implicit def optOrd[T](implicit ord: Ord[T]) = new Ord[Option[T]] {
    def compare(a: Option[T], b: Option[T]) = (a, b) match {
      case (Some(x), Some(y)) => ord.compare(x, y)
      case (None, _)          => true
      case (_, None)          => false
    }
  }


  implicit def pairOrd[T1, T2](implicit ordT1: Ord[T1], ordT2: Ord[T2]) = new Ord[(T1, T2)] {
    def compare(a: (T1, T2), b: (T1, T2)) =
      if (ordT1.compare(a._1, b._1)) true
      else if (ordT1.compare(b._1, a._1)) false
      else ordT2.compare(a._2, b._2)
  }

}

















