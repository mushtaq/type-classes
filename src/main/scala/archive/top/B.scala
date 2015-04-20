package top

trait Format[A] {
  def format(s: String): A
}

object Format {
  implicit def I[A](implicit formatD: Format[A]) = new Format[Int ⇒ A] {
    def format(s: String) = i ⇒ formatD.format(s + i.toString)
  }

  implicit def C[A](implicit formatD: Format[A]) = new Format[Char ⇒ A] {
    def format(s: String) = c ⇒ formatD.format(s + c.toString)
  }

  implicit object E extends Format[String] {
    def format(s: String) = s
  }
}

object B {
  def S[A](l: String, formatD: Format[A]) = new Format[A] {
    def format(s: String) = formatD.format(s + l)
  }
}
