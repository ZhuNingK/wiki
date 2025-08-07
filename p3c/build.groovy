def des = ".git/hooks/"
def f1 = new File("./p3c", "git-hook")
def f2 = new File(des, "pre-commit")

if (!f2.exists()) {
    f2.createNewFile()
}

f1.withReader {
    reader ->
        def lines = reader.readLines()
        f2.withWriter { writer ->
            lines.each {
                writer.append(it + "\r\n")
            }
        }
}
