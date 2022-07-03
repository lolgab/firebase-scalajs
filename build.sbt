import sys.process._
import _root_.org.scalablytyped.converter.plugin.ScalablyTypedConverterGenSourcePlugin.autoImport.stImport

organization := "com.github.lolgab"

scalaVersion := Versions.scala

enablePlugins(ScalablyTypedConverterGenSourcePlugin)
Compile / npmDependencies ++= Seq(
  "firebase" -> "9.8.4",
  "firebaseui" -> "6.0.1"
)

version := {
  (Compile / npmDependencies).value.map{ case (name, version) => s"${name}_${version}" }.mkString("_")
}

stOutputPackage := "agribiogabriele.typings"

stImport := {
  val result = stImport.value
  Seq("./amm", "modify-sources.sc").!!
  result
}

Compile / doc / sources := Seq()

ThisBuild / organization := "com.github.lolgab"
ThisBuild / homepage := Some(url("https://github.com/lolgab/firebase-scalajs"))
ThisBuild / licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / developers := List(
  Developer(
    "lolgab",
    "Lorenzo Gabriele",
    "lorenzolespaul@gmail.com",
    url("https://lolgab.github.io")
  )
)
