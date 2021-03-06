package org.esiea.martin_nicolas.projetmobiles3;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Classe pour les cocktails avec leurs caractéristiques
 */
public class Drink {
    private int id;
    private String name;
    private String category;
    private String alcoholic;
    private String glass;
    private String instruction;
    private String imgageUrl;
    private ArrayList<Ingredient> ingredients;


    /***
     *
     * Constructeur
     * @param json objet json transformé en Drink
     * @param isShort Si l'on charge l'objet pour la liste principale, on met is short a oui
     */
    public Drink(JSONObject json, boolean isShort) {
        try {
            this.setId(json.getInt("idDrink"));
            this.setName(json.getString("strDrink"));
            this.setImgageUrl(json.getString("strDrinkThumb"));

            if (this.getImgageUrl().equals("null"))
                this.setImgageUrl("http://www.novelupdates.com/img/noimagefound.jpg");

            //Si l'on charge l'objet pour les détails, on a besoin de plus d'informations ( catégorie, verre, ...)
            if (!isShort) {
                this.setCategory(json.getString("strCategory"));
                this.setAlcoholic(json.getString("strAlcoholic"));
                this.setGlass(json.getString("strGlass"));
                this.setInstruction(json.getString("strInstructions"));

                this.ingredients = new ArrayList<>();

                for (int i = 1; i <= 15; i++) {
                    String ingredient = json.getString("strIngredient" + i);
                    String measure = json.getString("strMeasure" + i);

                    if (!"".equals(ingredient)) {
                        this.ingredients.add(new Ingredient(ingredient, measure));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getImgageUrl() {
        return imgageUrl;
    }

    public void setImgageUrl(String imgageUrl) {
        this.imgageUrl = imgageUrl;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", alcoholic='" + alcoholic + '\'' +
                ", glass='" + glass + '\'' +
                ", instruction='" + instruction + '\'' +
                ", imgageUrl='" + imgageUrl + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
