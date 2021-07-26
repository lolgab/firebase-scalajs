val files = os.walk(os.pwd / "target" / "scala-3.0.1" / "src_managed")
  .filter(_.ext == "scala")

def modifyLine(line: String): String = {
  line
    .replaceAll("""@JSImport\("([^"]+)", "([^"]+)"\)""", """@JSImport("$1", "$2", "$1.$2")""")
    .replaceAll("""@JSImport\("([^"]+)", (JSImport[^,]+)\)""", """@JSImport("$1", $2, "$1")""")
}

val modified = files.map(f =>
  f -> os.read(f).linesIterator.map(modifyLine).mkString("\n")
)

modified.foreach { case (file, content) =>
  os.write.over(file, content)
}
