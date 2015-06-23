package com.scania.jmg.layers;

public class LayeredPackage {
    private final String packageName;

    public LayeredPackage(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LayeredPackage that = (LayeredPackage) o;

        return !(packageName != null ? !packageName.equals(that.packageName) : that.packageName != null);

    }

    @Override
    public int hashCode() {
        return packageName != null ? packageName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LayeredPackage{" +
                "packageName='" + packageName + '\'' +
                '}';
    }
}
