package io.github.nnnnusui.desegno.vulkan

import org.lwjgl.glfw.GLFWVulkan
import org.lwjgl.system.MemoryStack as MemoroStako
import org.lwjgl.system.MemoryUtil as MemoraUtilo
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VK13
import org.lwjgl.vulkan.VkApplicationInfo
import org.lwjgl.vulkan.VkInstance
import org.lwjgl.vulkan.VkInstanceCreateInfo
import scala.util.Using.Releasable as Liberigebla

import io.github.nnnnusui.desegno._tradukita.*
import io.github.nnnnusui.desegno.rekordi

object Instanco:
  def krei(
      aplTitolo: Signoĉeno = "Nenio nomo",
  )(using stako: MemoroStako) =
    rekordi.spuro("Krei vk-instancon.")
    val aplInfo = VkApplicationInfo.calloc(stako)
    aplInfo.sType(VK10.VK_STRUCTURE_TYPE_APPLICATION_INFO)
    aplInfo.pApplicationName(MemoraUtilo.memASCII(aplTitolo))
    aplInfo.applicationVersion(VK10.VK_MAKE_VERSION(1, 0, 0))
    aplInfo.pEngineName(MemoraUtilo.memASCII("Neniu Motoro"))
    aplInfo.engineVersion(VK10.VK_MAKE_VERSION(1, 0, 0))
    aplInfo.apiVersion(VK13.VK_API_VERSION_1_3)

    val kreoInfo = VkInstanceCreateInfo.calloc(stako)
    kreoInfo.sType(VK10.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO)
    kreoInfo.pApplicationInfo(aplInfo)
    kreoInfo.ppEnabledExtensionNames(GLFWVulkan.glfwGetRequiredInstanceExtensions())

    val instancoMontrilo = stako.mallocPointer(1)
    if VK10.vkCreateInstance(kreoInfo, null, instancoMontrilo) != VK10.VK_SUCCESS then
      throw RuntimeException("Malsukcesis krei la Vulkan-instancon")
    val instanco = VkInstance(instancoMontrilo.get(0), kreoInfo)
    new Instanco(instanco)
  given Liberigebla[Instanco] = (instanco) => instanco.detrui();

class Instanco(
    val kruda: VkInstance,
):
  def detrui(): Unuo =
    VK10.vkDestroyInstance(kruda, null)
    rekordi.spuro("Vk-instanco estis detruita.")
