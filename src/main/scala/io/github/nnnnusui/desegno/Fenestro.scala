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
    if !GLFW.glfwInit() then throw RuntimeException("Cannot init GLFW")
    GLFW.glfwWindowHint(GLFW.GLFW_CLIENT_API, GLFW.GLFW_NO_API)
    GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE)
    val montrilo = GLFW.glfwCreateWindow(larĝo, alteco, titolo, 0, 0)
    if montrilo == 0 then throw RuntimeException("Cannot create window")
    new Fenestro(montrilo)

  given Liberigebla[Fenestro] = (fenestro) => fenestro.fermi();

class Fenestro(
    val montrilo: Longa,
):
  def fermi(): Unuo =
    GLFW.glfwDestroyWindow(montrilo)
    GLFW.glfwTerminate()

  def devusFermiĝi(): Bulea =
    GLFW.glfwWindowShouldClose(montrilo)

  def bildigaBuklo(funkcio: Unuo => Unuo): Unuo =
    while !devusFermiĝi() do
      funkcio(())
      GLFW.glfwPollEvents()
