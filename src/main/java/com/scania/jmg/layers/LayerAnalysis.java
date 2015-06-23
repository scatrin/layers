package com.scania.jmg.layers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LayerAnalysis {
    private List<LayeredPackage> packages;

    public LayerAnalysis(List<LayeredPackage> packages) {
        this.packages = packages;
    }

    public Collection<Layer> getLayers() {
        return Collections.emptyList();
    }

    public List<LayeredPackage> getPackages() {
        return packages;
    }
}
