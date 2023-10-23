package util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Products {

 PRODUCT1("CHERY", "a113707110ca", "СВЕЧА ЗАЖИГАНИЯ CH FORA TIGGO 18 EASTAR INDIS KIMO M11 QQ6 RIICH VERY");

 private String manufacturer;
 private String article;
 private String title;


 //loop through whole array of products
 public static Products getProductByArticle(String article) throws Exception {
     return Arrays.stream(values()).filter(product->product.getArticle().equals(article)).findFirst().orElseThrow(()->new Exception("No such product found"));
 }
}
