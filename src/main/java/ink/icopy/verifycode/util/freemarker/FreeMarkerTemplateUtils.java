package ink.icopy.verifycode.util.freemarker;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

/** @author lizhengguang */
public class FreeMarkerTemplateUtils {
  private FreeMarkerTemplateUtils() {}

  private static final Configuration CONFIGURATION =
      new Configuration(Configuration.VERSION_2_3_22);

  static {
    // 这里比较重要，用来指定加载模板所在的路径
    try {
      CONFIGURATION.setTemplateLoader(
          new FileTemplateLoader(
              new File("/Users/lizhengguang/Desktop/doWork/verify-code/templates")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    CONFIGURATION.setDefaultEncoding("UTF-8");
    CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
  }

  public static Template getTemplate(String templateName) throws IOException {
    try {
      return CONFIGURATION.getTemplate(templateName);
    } catch (IOException e) {
      throw e;
    }
  }

  public static void clearCache() {
    CONFIGURATION.clearTemplateCache();
  }
}
