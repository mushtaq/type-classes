package data

import models.Book

object Data {
  val books = List(
    Book("odersky", "scala prog", 100, false),
    Book("odersky", "apple", 100, false),
    Book("odersky", "complexity", 400, false),
    Book("misky", "ocaml prog", 1000, true),
    Book("misky", "sml", 88, false),
    Book("hickey", "clojure prog", 500, true)
  )

  val ints = List(2, 5, 9, 1, 2, 0, 4, 3)
  val strings = List("mushtaq", "ahmed", "vishal", "amar")

  val pairs = List(
    ("scala", 100),
    ("apple", 100),
    ("complex", 400),
    ("ocaml", 1000),
    ("sml", 88),
    ("clojure", 500)
  )

  val opts = List(Some(8), None, Some(3), None, Some(0))

  val pairedOpts = List(
    (Some("scala"), Some(100)),
    (Some("apple"), Some(100)),
    (Some("complex"), None),
    (None, Some(1000)),
    (Some("sml"), Some(88)),
    (Some("clojure"), Some(500)),
    (None, None)
  )

}
