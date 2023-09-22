package continued.hideaway.mod.feat.location;

import continued.hideaway.mod.HideawayContinued;
import continued.hideaway.mod.feat.discord.PresenceImage;
import continued.hideaway.mod.feat.ext.BossHealthOverlayAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerScoreboard;
import net.minecraft.world.phys.Vec3;

import java.util.Collection;

public enum Location {

    // Locations
    ASTRAL_AUDITORIUM(
        "At the Astral Auditorium",
        "The show must go on! 🎭",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    ISLAND_EMPORIUM(
        "At the Island Emporium",
        "Ready to glam up my room 💺",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    FURNITURE_FUNCTIONATOR(
        "At the Furniture Functionator",
        "Designing a swanky hotel room 😎",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    MARKETPLACE_PIER(
        "On Marketplace Pier",
        "I love a shopping spree! 🛍️",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    MONKEY_BROTHERS(
        "With the Monkey Brothers",
        "Hey... you got the goods? 🥭",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    TINTS_N_TEXTURES(
        "At Tints'N'Textures",
        "That colour really suits you! 🎨",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    SKULL_ISLAND(
        "On Skull Island",
        "There's no turning back now. 💀",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    WARDROBE_WHEEL(
        "At the Wardrobe Wonder Wheel",
        "Chilling with the Wonder Squid 🍹",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),

    // Activities
    HOTEL_ROOM_SELF(
        "In their room",
        "Look at that view! 🏝️",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    HOTEL_ROOM_OTHER(
        "In <player>'s room",
        "Look at that view! 🏝️",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    // 12AM = 2PM
    POOL_PARTY(
        "At a Pool Party",
        "Look at that view! 🏝️",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),

    WARDROBE(
        "In the Wardrobe",
        "Don't look! 👚",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),

    // Minigames
    BONFIRE(
        "At a bonfire",
        "... *crackle*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    BOUNCE_BATTLE(
        "Playing Bounce Battle",
        "... *boing*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    BREAKFAST(
        "Eating breakfast",
        "... *crunch*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    JETSKI(
        "In a Jetski Race",
        "... *nyoom*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    KING_OF_CASTLE(
        "Playing King of the Castle",
        "... *royal noises*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    TREASURE_DIVING(
        "Diving for treasure",
        "... *clink*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    VOLLEYBALL(
        "Playing Beach Volleyball",
        "... *thwap*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),

    // Miscellaneous
    BANANA(
        "By the Banana",
        "P O T A S S I U M",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    GENERIC(
        "On Hideaway Island",
        "Relaxing in the sun ☀️",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    SECRET(
        "You saw nothing...",
        "This is all just a dream... 😵‍💫",
        PresenceImage.Large.SCENE_DARK,
        PresenceImage.Small.ROUNDEL
    ),
    UNKNOWN(
        "Using HideawayContinued",
        "Somewhere in the metaverse... 🚀",
        PresenceImage.Large.SCENE_DARK,
        PresenceImage.Small.ROUNDEL
    ),
    ;

    public String name;
    public final String description;
    public final PresenceImage.Large largeIcon;
    public final PresenceImage.Small smallIcon;

    Location(
        String name,
        String description,
        PresenceImage.Large largeIcon,
        PresenceImage.Small smallIcon
    ) {
        this.name = name;
        this.description = description;
        this.largeIcon = largeIcon;
        this.smallIcon = smallIcon;
    }

    // Lord have mercy on my soul for the amount of intense,
    // messy and complicated hardcoding you are about to be
    // subjected to. Grab a paper bag if you get sick easily.
    public static void check() {
        if (!HideawayContinued.connected()) {
            HideawayContinued.setLocation(UNKNOWN);
            return;
        }

        Minecraft client = Minecraft.getInstance();
        MinecraftServer server = client.player.getServer();
        Vec3 location = client.player.position();
        String bossBarName;

        // Location-based
        if (location.closerThan(new Vec3(66.5f, 5f, -130.5f), 5)) HideawayContinued.setLocation(WARDROBE_WHEEL);
        else if (location.closerThan(new Vec3(-77.5f, 6f, -263.5f), 7)) HideawayContinued.setLocation(MONKEY_BROTHERS);
        else if (location.closerThan(new Vec3(-28.5f, 5f, -120.5f), 20)) HideawayContinued.setLocation(FURNITURE_FUNCTIONATOR);
        else if (location.closerThan(new Vec3(54.5f, 5f, -119.5f), 20)) HideawayContinued.setLocation(ISLAND_EMPORIUM);
        else if (location.closerThan(new Vec3(59.5f, 15f, -82.5f), 20)) HideawayContinued.setLocation(TINTS_N_TEXTURES);
        else if (location.closerThan(new Vec3(148.5f, 15f, -403.5f), 20)) HideawayContinued.setLocation(BANANA);
        else if (location.closerThan(new Vec3(234.5f, 0f, -361.5f), 50)) HideawayContinued.setLocation(BONFIRE);
        else if (location.closerThan(new Vec3(317.5f, 4f, -193.5f), 50)) HideawayContinued.setLocation(BREAKFAST);
        else if (location.closerThan(new Vec3(145.5f, 0f, -203.5f), 50)) HideawayContinued.setLocation(ASTRAL_AUDITORIUM);
        else if (location.closerThan(new Vec3(-319.5f, 9f, -236.5f), 65)) HideawayContinued.setLocation(SKULL_ISLAND);
        else if (location.closerThan(new Vec3(122.5f, 3f, -94.5f), 65)) HideawayContinued.setLocation(MARKETPLACE_PIER);
        else if (server != null) {
            // Scoreboard-based
            ServerScoreboard board = server.getScoreboard();
            Collection<String> boardNames = getBoardNames(board);
            if (client.player.isSpectator()) HideawayContinued.setLocation(WARDROBE);
            else if (boardNames.contains("\ue4d5")) HideawayContinued.setLocation(KING_OF_CASTLE);
            else if (boardNames.contains("\ue4db")) HideawayContinued.setLocation(BOUNCE_BATTLE);
            else if (boardNames.contains("\ue4dc")) HideawayContinued.setLocation(TREASURE_DIVING);
            else if (boardNames.contains("\ue523")) HideawayContinued.setLocation(JETSKI);
            else if (boardNames.contains("\ue524")) HideawayContinued.setLocation(VOLLEYBALL);
            else if (server.getCustomBossEvents().getEvents().stream().findFirst().isPresent()) {
                if (boardNames.contains("\ue4d5")) HideawayContinued.setLocation(KING_OF_CASTLE);
                else if (boardNames.contains("\ue4db")) HideawayContinued.setLocation(BOUNCE_BATTLE);
                else if (boardNames.contains("\ue4dc")) HideawayContinued.setLocation(TREASURE_DIVING);
                else if (boardNames.contains("\ue523")) HideawayContinued.setLocation(JETSKI);
                else if (boardNames.contains("\ue524")) HideawayContinued.setLocation(VOLLEYBALL);
            }
            // Bossbar-based
            else if ((bossBarName = ((BossHealthOverlayAccessor)client.gui.getBossOverlay()).getBossBarName()) != null) {
                if (bossBarName.contains("\uE612 | Editor Mode is")) HideawayContinued.setLocation(HOTEL_ROOM_SELF);
                else if (bossBarName.contains("\uE293 ") && bossBarName.contains("'s Room")) {
                    String visitingPlayerName = ((BossHealthOverlayAccessor)client.gui.getBossOverlay()).getBossBarName().split(" ")[0];
                    visitingPlayerName = visitingPlayerName.replace("'s", "");

                    Location.HOTEL_ROOM_OTHER.name = "In " + visitingPlayerName + "'s room";
                    HideawayContinued.setLocation(HOTEL_ROOM_OTHER);
                }
                else if (bossBarName.contains("\uE293 ")) {
                    Location.HOTEL_ROOM_OTHER.name = "In a someone's room \uD83E\uDD37";
                    HideawayContinued.setLocation(HOTEL_ROOM_OTHER);
                }
            }
            else HideawayContinued.setLocation(GENERIC);
        }
        else HideawayContinued.setLocation(GENERIC);
    }

    private static Collection<String> getBoardNames(ServerScoreboard board) {
        Collection<String> names = board.getTeamNames();
        names.add(board.getObjectives().stream().toList().get(0).getDisplayName().getString());
        return names;
    }
}