package io.github.nnnnusui.desegno
import org.lwjgl.glfw.GLFW
import scala.util.Using.Releasable as Liberigebla
import scala.util.Using as Uzanta

import io.github.nnnnusui.desegno._tradukita.*

object Fenestro:
  def krei(
      larĝo: Entjero = 800,
      alteco: Entjero = 600,
      titolo: Signoĉeno = "",
  ) =
    rekordi.spuro("Krei fenestron.")
    if !GLFW.glfwInit() then throw RuntimeException("Ne povas pravalorigi GLFW")
    GLFW.glfwWindowHint(GLFW.GLFW_CLIENT_API, GLFW.GLFW_NO_API)
    GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE)
    val montrilo = GLFW.glfwCreateWindow(larĝo, alteco, titolo, 0, 0)
    if montrilo == 0 then throw RuntimeException("Ne povas krei fenestron")
    new Fenestro(montrilo)

  given Liberigebla[Fenestro] = (fenestro) => fenestro.fermi();

class Fenestro(
    val montrilo: Longa,
):
  def fermi(): Unuo =
    GLFW.glfwDestroyWindow(montrilo)
    GLFW.glfwTerminate()
    rekordi.spuro("La fenestro estis fermita.")

  def devusFermiĝi(): Bulea =
    GLFW.glfwWindowShouldClose(montrilo)

  def bildigaBuklo(funkcio: Unuo => Unuo): Unuo =
    rekordi.spuro("Komencos bildigo buklo.")
    while !devusFermiĝi() do
      funkcio(())
      GLFW.glfwPollEvents()
