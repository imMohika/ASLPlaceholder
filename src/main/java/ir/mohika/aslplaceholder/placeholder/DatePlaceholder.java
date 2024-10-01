package ir.mohika.aslplaceholder.placeholder;

import ch.andre601.advancedserverlist.api.PlaceholderProvider;
import ch.andre601.advancedserverlist.api.objects.GenericPlayer;
import ch.andre601.advancedserverlist.api.objects.GenericServer;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DatePlaceholder extends PlaceholderProvider {
  private final Logger logger;

  public DatePlaceholder(Logger logger) {
    super("date");
      this.logger = logger;
  }

  @Override
  public String parsePlaceholder(String placeholder, GenericPlayer player, GenericServer server) {
    if (placeholder == null) {
      return null;
    }

    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat(placeholder);
      dateFormat.setTimeZone(TimeZone.getDefault());

      Date date = new Date();
      return dateFormat.format(date);
    } catch (IllegalArgumentException exception) {
      logger.info("Failed to parse date placeholder: {}", placeholder);
      return null;
    }

  }
}
