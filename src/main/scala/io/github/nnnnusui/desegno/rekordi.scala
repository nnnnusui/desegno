package io.github.nnnnusui.desegno

import scribe.modify.LevelFilter
import scribe.Level

object rekordi:
  export scribe.debug as sencimiga
  export scribe.error as eraro
  export scribe.info
  export scribe.trace as spuro
  export scribe.warn as averta

  scribe.Logger.root
    .withModifier(LevelFilter >= Level.Trace)
    .replace()
