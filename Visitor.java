public interface Visitor{
    public void visitFile(String name,File file);

    public void visitDirectory(String name,Directory directory);

    public void visitedDirectory();
}