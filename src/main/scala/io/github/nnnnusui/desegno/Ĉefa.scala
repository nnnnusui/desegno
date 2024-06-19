package io.github.nnnnusui.desegno

import org.lwjgl.system.MemoryStack.stackPush as stakoPuŝi
import org.lwjgl.system.MemoryStack as MemoroStako
import scala.main as ĉefa
import scala.util.Using.Manager as UzantaManaĝero
import scala.util.Using as Uzanta

import io.github.nnnnusui.desegno._tradukita.*
import io.github.nnnnusui.desegno.vulkan as vk

@ĉefa def ĉefa =
  presiln("Scala skribita en esperanto.")
  val aplTitolo = "desegno"
  UzantaManaĝero: uzi =>
    given MemoroStako = uzi(stakoPuŝi())
    val vkInstanco = uzi(vk.Instanco.krei(aplTitolo = aplTitolo))
    val fenestro = uzi(Fenestro.krei(titolo = aplTitolo))
    fenestro.bildigaBuklo: _ =>
      ()
