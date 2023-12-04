package com.ddangme.eatstory.web.form.recipe;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RecipeStepWriteForm {

    private String detail;
    private MultipartFile photo;
    private String ingredient;
    private String tool;
    private String fire;
    private String tip;
}
