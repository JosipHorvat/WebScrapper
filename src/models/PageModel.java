package models;

import records.Element;
import enums.ElementType;

import java.util.HashSet;
import java.util.Set;

public class PageModel {

    private String path;
    private Set<Element<?>> elements;

    public PageModel(final String path) {
        this.path = path;
        this.elements = new HashSet<>();
    }

    public void print() {
        System.out.println("=== ELEMENTS ===");
        for (final Element<?> item : this.elements) {
            System.out.println(item);
        }
    }

    public void printLinks() {
        System.out.println("=== LINKS ===");
        for (final Element<?> item : this.elements) {
                if (item.getElementType() == ElementType.LINK) {
                    System.out.println(item.getProperties());
                }
        }
    }

    public void printImages() {
        System.out.println("=== IMAGES ===");
        for (final Element<?> item : this.elements) {
                if (item.getElementType() == ElementType.IMAGE) {
                    System.out.println(item.getProperties());
            }

        }
    }

    public void addElement(final Element<?> element) {
        this.elements.add(element);
    }

}