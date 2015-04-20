package pwl.tc_idiomatic

trait Ord[T] {
  def compare(a: T, b: T): Boolean
}

object Ord {

  def apply[T: Ord] = implicitly[Ord[T]]


  implicit val intOrd = new Ord[Int] {
    def compare(a: Int, b: Int) = a < b
  }

  implicit val doubleOrd = new Ord[Double] {
    def compare(a: Double, b: Double) = a < b
  }

  implicit val strOrd = new Ord[String] {
    def compare(a: String, b: String) = a < b
  }

  implicit def optOrd[T: Ord] = new Ord[Option[T]] {
    def compare(a: Option[T], b: Option[T]) = (a, b) match {
      case (Some(x), Some(y)) => Ord[T].compare(x, y)
      case (None, _)          => true
      case (_, None)          => false
    }
  }


  implicit def pairOrd[T1: Ord, T2: Ord] = new Ord[(T1, T2)] {
    def compare(a: (T1, T2), b: (T1, T2)) =
      if (Ord[T1].compare(a._1, b._1)) true
      else if (Ord[T1].compare(b._1, a._1)) false
      else Ord[T2].compare(a._2, b._2)
  }

}

















