package ir.mohika.aslplaceholder;

import ch.andre601.advancedserverlist.api.AdvancedServerListAPI;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import ir.mohika.aslplaceholder.placeholder.DatePlaceholder;
import org.slf4j.Logger;

@Plugin(
    id = "aslplaceholder",
    name = "ASLPlaceholder",
    version = BuildConstants.VERSION,
    url = "im.mohika.ir",
    authors = {"imMohika"},
    dependencies = {@Dependency(id = "advancedserverlist")})
public class ASLPlaceholder {

  @Inject private Logger logger;

  @Subscribe
  public void onProxyInitialization(ProxyInitializeEvent event) {
    logger.info("Its 3am and I'm awake!");

    AdvancedServerListAPI asl = AdvancedServerListAPI.get();
    asl.addPlaceholderProvider(new DatePlaceholder(logger));
  }
}
