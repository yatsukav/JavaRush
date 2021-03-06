package net.iatsuk.problems.chapter09

import java.io.{File, PrintWriter}
import java.nio.file.Files

import scala.io.Source

object Exercise01 extends App {
  val file = new File("ex01.txt")
  val pwIn = new PrintWriter(file)
  pwIn.println("Lorem")
  pwIn.println("Ipsum")
  pwIn.println("dolor")
  pwIn.close()

  val source = Source.fromFile(file)
  val lines = source.getLines.toArray.reverse
  source.close()

  val pwOut = new PrintWriter(file)
  lines.foreach(pwOut.println)
  pwOut.close()

  Files.deleteIfExists(file.toPath)
}
