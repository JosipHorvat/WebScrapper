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
       elements.forEach(element -> System.err.println(element));
    }

    public void printLinks() {
        System.out.println("=== LINKS ===");
        elements.stream()
                .filter(element -> element.getElementType().equals(ElementType.LINK))
                .map(Element::getProperties)
                .forEach(System.out::println);
    }

    public void printImages() {
        System.out.println("=== IMAGES ===");
        elements.stream()
                .filter(element -> element.getElementType().equals(ElementType.IMAGE))
                .map(Element::getProperties)
                .forEach(System.out::println);

    }

    public void addElement(final Element<?> element) {
        this.elements.add(element);
    }

}