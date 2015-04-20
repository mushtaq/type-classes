package typeclasses

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

  implicit val stringOrd = new Ord[String] {
    def compare(a: String, b: String) = a < b
  }

  implicit def optOrd[T](implicit tOrd: Ord[T]): Ord[Option[T]] = new Ord[Option[T]] {
    def compare(a: Option[T], b: Option[T]) = (a, b) match {
      case (Some(x), Some(y)) => tOrd.compare(x, y)
      case (None, Some(_))    => true
      case (_, _)             => false
    }
  }

  implicit def pairOrd[T1, T2](implicit t1Ord: Ord[T1], t2Ord: Ord[T2]): Ord[(T1, T2)] = new Ord[(T1, T2)] {
    def compare(a: (T1, T2), b: (T1, T2)) =
      if (t1Ord.compare(a._1, b._1)) true
      else if (t1Ord.compare(b._1, a._1)) false
      else t2Ord.compare(a._2, b._2)
  }
}
