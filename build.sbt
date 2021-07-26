import sys.process._
import _root_.org.scalablytyped.converter.plugin.ScalablyTypedConverterGenSourcePlugin.autoImport.stImport

organization := "com.github.lolgab"

scalaVersion := "3.0.1"

enablePlugins(ScalablyTypedConverterGenSourcePlugin)
Compile / npmDependencies ++= Seq(
  "firebase" -> "8.8.0",
  "firebaseui" -> "4.8.1"
)

version := {
  (Compile / npmDependencies).value.map{ case (name, version) => s"${name}_$version" }.mkString("_")
}

stOutputPackage := "agribiogabriele.typings"

stImport := {

  val result = stImport.value

  Seq("amm", "modify-sources.sc").!!

  result

}

inThisBuild(List(
  organization := "com.github.lolgab",
  homepage := Some(url("https://github.com/lolgab/firebase-scalajs")),
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "lolgab",
      "Lorenzo Gabriele",
      "lorenzolespaul@gmail.com",
      url("https://lolgab.github.io")
    )
  )
))