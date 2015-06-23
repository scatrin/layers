package com.scania.jmg.layers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

public class LayerAnalyzerTest {
    @Test
    public void test() {
        LayerAnalysis analysis = new LayerAnalyzer().analyzeLayers();
        assertThat(analysis.getLayers().size(), is(3));
    }
}