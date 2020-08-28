package me.lightlord323dev.cursedlevels.api.handler;

import me.lightlord323dev.cursedlevels.Main;
import me.lightlord323dev.cursedlevels.handler.CursedGUIHandler;
import me.lightlord323dev.cursedlevels.handler.SkillGUIHandler;
import me.lightlord323dev.cursedlevels.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Luda on 8/16/2020.
 */
public class HandlerRegistry {

    private List<Handler> handlers;

    // handlers
    private SkillGUIHandler skillGUIHandler;
    private MessageUtil messageUtil;

    public void loadHanders() {
        handlers = new ArrayList<>();
        // REGISTER HANDLERS
        handlers.addAll(Arrays.asList(
                new CursedGUIHandler(),
                skillGUIHandler = new SkillGUIHandler(),
                messageUtil = new MessageUtil()
        ));
        // call onLoad method
        handlers.forEach(handler -> {
            handler.onLoad();
            if (handler instanceof Listener) {
                Bukkit.getPluginManager().registerEvents(((Listener) handler), Main.getInstance());
            }
        });
    }

    public void unloadHandlers() {
        handlers.forEach(Handler::onUnload);
    }

    public SkillGUIHandler getSkillGUIHandler() {
        return skillGUIHandler;
    }

    public MessageUtil getMessageUtil() {
        return messageUtil;
    }
}