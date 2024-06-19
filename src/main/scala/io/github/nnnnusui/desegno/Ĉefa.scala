package io.github.nnnnusui.desegno

import scala.main as ĉefa
import scala.util.Using as Uzanta

import io.github.nnnnusui.desegno._tradukita.*

@ĉefa def ĉefa =
  presiln("Scala skribita en esperanto.")
  Uzanta(Fenestro.krei()): fenestro =>
    fenestro.bildigaBuklo: _ =>
      ()
