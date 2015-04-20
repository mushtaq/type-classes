def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case Nil                       => List(x)
  case head :: tail if x <= head => x :: xs
  case head :: tail              => head :: insert(x, tail)
}

def iSort(xs: List[Int]): List[Int] = xs match {
  case Nil          => Nil
  case head :: tail => insert(head, iSort(tail))
}

iSort(List(1, 4, 6, 2, 3, 9, 6, 7))
