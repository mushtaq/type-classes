import pwl.top.{B, Format}
import B._
import Format._
1
def printf[A](format: Format[A]): A = format.format("")
val fmt :Format[Int ⇒ Char ⇒ String] =
  S("Int: ", I(S(" Char: ", C(S(".", E)))))
val test = printf (fmt) (3) ('a')
printf (fmt)(3)('r')



