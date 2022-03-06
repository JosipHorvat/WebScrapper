package services;

import models.PageModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import records.Element;
import enums.ElementType;
import records.Image;
import records.Link;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class ScrappingService {

    public Optional<PageModel>  scrap(final String url) {
        try {
            final  PageModel pageModel = new PageModel(url);
            final Document document = Jsoup.connect(url).get();
            final Elements elements = document.select("a[href],img[src]");
            return Optional.of(this.processElements(elements, pageModel)) ;
        } catch (final IOException e) {
            System.err.println("For url: " + url);
            e.printStackTrace();
        }
        return Optional.empty();

    }

    private PageModel processElements(final Elements elements, final PageModel pageModel) {
        elements.forEach(element -> {
            if (element.tagName().equals("img")) {
                this.processImage(element, pageModel);
            } else if (element.tagName().equals("a")) {
                this.processLink(element, pageModel);
            }
        });
        return pageModel;
    }
    
    private void processLink(final org.jsoup.nodes.Element element, final PageModel pageModel) {
        final String href = element.attr("abs:href");
        final String text = element.text();
        final Link link = new Link(text);
        final Element<Link> elementRecord = new Element<>(href, link, ElementType.LINK);
        pageModel.addElement(elementRecord);
    }

    private void processImage(final org.jsoup.nodes.Element element, final PageModel pageModel) {
        final String src = element.attr("abs:src");
       this.getImage(src).ifPresent(pageModel::addElement);
    }

    private Optional<Element<Image>>  getImage(final String src) {
        try {
            final URL url = new URL(src);
            final BufferedImage bufferedImage = ImageIO.read(url);
            if (bufferedImage != null) {
                final Image image = new Image(bufferedImage.getWidth(), bufferedImage.getHeight());
                final Element<Image> element = new Element<>(src, image, ElementType.IMAGE);
                return Optional.of(element);
            }
        } catch (final IOException e) {
            System.err.println("Error during creating image with src: " + src);
            e.printStackTrace();
        }
        return Optional.empty();
    }

}