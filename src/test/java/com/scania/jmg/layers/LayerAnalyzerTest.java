package com.scania.jmg.layers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;
import org.junit.Test;

public class LayerAnalyzerTest {

    @Test
    public void test() {
        LayerAnalysis analysis = new LayerAnalyzer("src/test/java").analyzeLayers();
        assertThat(analysis.getLayers().size(), is(3));
    }

    @Test
    public void testFindPackageInfo() {
        LayerAnalysis analysis = new LayerAnalyzer("src/test/java").analyzeLayers();
        assertThat(analysis.getPackages().size(), is(4));
        assertThat(analysis.getPackages(), contains(new LayeredPackage("com.scania.jmg.layers.testproject.dao")));
    }
}