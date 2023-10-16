package util;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

// Context is used to store data (for singleton pattern)
// Constructor is private to make sure that only one instance is created at runtime (singleton), the instance is created inside the class
@Slf4j
public class ScenarioContext {
    private static ScenarioContext instance;

    private Map<ContextKeys, Object> scenarioContext;

     private ScenarioContext() {
          scenarioContext = new HashMap<ContextKeys, Object>();
     }

     public static ScenarioContext getInstance() {
          if (instance == null) {
               instance = new ScenarioContext();
          }
          return instance;
     }

     public static void save(ContextKeys key, Object object){
          getInstance().scenarioContext.put(key, object);
     }

     public static <T> T retrieve(ContextKeys key, Class<T> objectClass){
          return objectClass.cast(getInstance().scenarioContext.get(key));
     }

     public void clearScenarioContext() {
          scenarioContext.clear();
          log.info("Scenario Context was cleared");
     }
}
