import sys.process._
import _root_.org.scalablytyped.converter.plugin.ScalablyTypedConverterGenSourcePlugin.autoImport.stImport

organization := "com.github.lolgab"

scalaVersion := "3.1.0"

enablePlugins(ScalablyTypedConverterGenSourcePlugin)
Compile / npmDependencies ++= Seq(
  "firebase" -> "9.6.3",
  "firebaseui" -> "6.0.0"
)

version := {
  (Compile / npmDependencies).value.map{ case (name, version) => s"${name}_${version}" }.mkString("_")
}

stOutputPackage := "agribiogabriele.typings"

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
