import $file.project.versions

val files = os.walk(os.pwd / "target" / s"scala-${versions.Versions.scala}" / "src_managed")
  .filter(_.ext == "scala")

def modifyLine(line: String): String = {
  line.replaceAll("app/dist/", "")
}

val modified = files.map(f =>
  f -> os.read(f).linesIterator.map(modifyLine).mkString("\n")
)

modified.foreach { case (file, content) =>
  os.write.over(file, content)
}
