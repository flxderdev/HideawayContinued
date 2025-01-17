package continued.hideaway.mod.feat.config;

import continued.hideaway.mod.util.Constants;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Sync;

@Sync(Option.SyncMode.NONE)
@Modmenu(modId = Constants.MOD_ID)
@Config(name = "hp-config", wrapperName = "HideawayPlusConfig")
public class HideawayPlusConfigModel {
    // General
    public boolean hideCosmetics = false;
    public boolean discordRPC = true;

    public boolean inventoryRarities = true;

    public boolean autoSell = false;

    // Rooms
    //public boolean autoEnableEditor = true;

    // Sound

    // These are backwards
    public boolean noAmbientSounds = true;

    public boolean noActivitySongs = true;
}