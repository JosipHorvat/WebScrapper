import constants.Constants;
import models.PageModel;
import services.ScrappingService;

import java.util.Optional;

public class Main {



    public static void main(final String[] args) {
        final ScrappingService scrappingService = new ScrappingService();
        final Optional<PageModel> optionalPageModel = scrappingService.scrap(Constants.START_PAGE);
        optionalPageModel.ifPresent(pageModel -> {
            pageModel.printLinks();
            pageModel.printImages();
            pageModel.print();

        });
    }

}