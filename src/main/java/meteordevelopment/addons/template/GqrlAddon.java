package meteordevelopment.addons.template;

import meteordevelopment.addons.template.commands.*;
import meteordevelopment.addons.template.modules.*;
import meteordevelopment.addons.template.modules.hud.*;
import meteordevelopment.meteorclient.MeteorAddon;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.invoke.MethodHandles;

public class GqrlAddon extends MeteorAddon{
	public static final Logger LOG = LogManager.getLogger();
	public static final Category CATEGORY = new Category("Gqrl");

	@Override
	public void onInitialize() {
		LOG.info("Initializing GqrlAddon");

		// Required when using @EventHandler
		MeteorClient.EVENT_BUS.registerLambdaFactory("meteordevelopment.addons.template", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

		// Modules
		Modules.get().add(new AutoMountBypassDupe());
		Modules.get().add(new ItemFrameDupe());

		// Commands
		Commands.get().add(new GqrlCommand());

		// HUD
		HUD hud = Modules.get().get(HUD.class);
		hud.elements.add(new HudExample(hud));
	}

	@Override
	public void onRegisterCategories() {
		Modules.registerCategory(CATEGORY);
	}
}
