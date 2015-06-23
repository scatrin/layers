package com.scania.jmg.layers;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class LayerAnalyzer {

    public static final Path PACKAGE_INFO = Paths.get("package-info.java");
    private final Path rootPath;

    public LayerAnalyzer(String rootPath) {
        this.rootPath = Paths.get(rootPath);
    }

    public LayerAnalysis analyzeLayers() {
        final List<LayeredPackage> packages = getPackages();

        return new LayerAnalysis(packages);
    }

    private List<LayeredPackage> getPackages() {
        final ArrayList<LayeredPackage> packages = new ArrayList<LayeredPackage>();

        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.getFileName().equals(PACKAGE_INFO)) {
                        packages.add(createPackage(file));
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return packages;
    }

    private LayeredPackage createPackage(Path file) {
        return new LayeredPackage(rootPath.relativize(file.getParent()).toString().replace(File.separator, "."));
    }
}
