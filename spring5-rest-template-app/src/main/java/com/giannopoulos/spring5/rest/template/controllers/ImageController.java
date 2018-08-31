package com.giannopoulos.spring5.rest.template.controllers;

import com.giannopoulos.spring5.rest.template.model.RecipeDTO;
import com.giannopoulos.spring5.rest.template.services.ImageService;
import com.giannopoulos.spring5.rest.template.services.RecipeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(ImageController.BASE_URL)
public class ImageController {

    public static final String BASE_URL = "/api/v1/recipies";

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @PostMapping("{id}/image")
    public void handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){

        imageService.saveImageFile(Long.valueOf(id), file);
    }

    @GetMapping("{id}/recipeimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {

        RecipeDTO recipeDTO = recipeService.findRecipeById(Long.valueOf(id));

        if (recipeDTO.getImage() != null) {
            byte[] byteArray = new byte[recipeDTO.getImage().length];
            int i = 0;

            for (Byte wrappedByte : recipeDTO.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

}
