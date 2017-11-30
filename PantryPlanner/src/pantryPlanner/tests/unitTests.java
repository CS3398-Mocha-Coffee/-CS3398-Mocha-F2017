///*
///**
// * 
// *
//package pantryPlanner.tests;
//
//import static org.junit.Assert.*;
//
////import static org.junit.Assert.assertEquals;
////import static org.junit.Assert.assertTrue;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Map.Entry;
//
//import org.junit.Test;
//
//import pantryPlanner.common.Ingredient;
//import pantryPlanner.common.Inventory;
//import pantryPlanner.views.recipeMenu; 
////import pantryPlanner.common.Recipe; 
//
///**
// * @author sfgib
// *
// 
//
//public class unitTests {
//	@Test
//	public void addIngredientTest() {
//	recipeMenu r = new recipeMenu();
//	for(int i=0; i<10; i++){
//		
//		String i_name = "ingredient_" + i;
//		Inventory ing = new Inventory(null);
//		if(ing.hasItem(itemId) == true)
//		ing.addItem(i_name, ing);
//	}
//	for (Entry<String, Ingredient> entry : r.getIngredients().entrySet())
//	{
//		System.out.println(entry.getKey() + "/" + entry.getValue().getName());
//	}
//}
//
//
//@Test
//public void ingredientNameTest() {
//	Cookbook cb = new Cookbook(null);
//	cb.queryI("rice");
//	cb.queryI("carrots");
//	cb.queryI("potatoes");
//	cb.queryI("chicken");
//	cb.queryI("chocolate");
//
//	for(Entry<String, Ingredient> entry : cb.getIngsMap().entrySet()){
//		System.out.println(entry.getKey() + "/" + entry.getValue().getName());
//		assertEquals(entry.getKey(), entry.getValue().getName());
//	}
//
//	//tests getRecips() and getRecipeNames()
//	for(Entry<String, Ingredient> entry : cb.getIngsMap().entrySet()){
//		Collection<Recipe> recipes = entry.getValue().getRecips();
//		HashSet<String> recipe_names = entry.getValue().getRecipeNames();
//		for(Recipe r:recipes){
//			assertTrue(recipe_names.contains(r.getName()));
//		}
//	}
//}
//	
//
//}
