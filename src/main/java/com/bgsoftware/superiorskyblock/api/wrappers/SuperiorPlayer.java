package com.bgsoftware.superiorskyblock.api.wrappers;

import com.bgsoftware.superiorskyblock.api.data.PlayerDataHandler;
import com.bgsoftware.superiorskyblock.api.enums.BorderColor;
import com.bgsoftware.superiorskyblock.api.enums.HitActionResult;
import com.bgsoftware.superiorskyblock.api.island.Island;
import com.bgsoftware.superiorskyblock.api.island.IslandPrivilege;
import com.bgsoftware.superiorskyblock.api.island.PlayerRole;
import com.bgsoftware.superiorskyblock.api.missions.Mission;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public interface SuperiorPlayer {

    /*
     *   General Methods
     */

    /**
     * Get the UUID of the player.
     */
    UUID getUniqueId();

    /**
     * Get the last known name of the player.
     */
    String getName();

    /**
     * Get the last known skin-texture value of the player.
     */
    String getTextureValue();

    /**
     * Set the skin-texture value for the player.
     * @param textureValue The skin texture.
     */
    void setTextureValue(String textureValue);

    /**
     * Update the last time player joined or left the server.
     */
    void updateLastTimeStatus();

    /**
     * Get the last time player joined or left the server.
     */
    long getLastTimeStatus();

    /**
     * Update the cached name with the current player's name.
     */
    void updateName();

    /**
     * Get the player object.
     */
    Player asPlayer();

    /**
     * Get the offline-player object.
     */
    OfflinePlayer asOfflinePlayer();

    /**
     * Check whether or not the player is online.
     */
    boolean isOnline();

    /**
     * Check whether or not this player is in a gamemode with fly mode enabled.
     */
    boolean hasFlyGamemode();

    /**
     * Check whether or not the player has a permission.
     */
    boolean hasPermission(String permission);

    /**
     * Check whether or not the player has a permission without having op.
     */
    boolean hasPermissionWithoutOP(String permission);

    /**
     * Check whether or not the player has a permission on his island.
     */
    boolean hasPermission(IslandPrivilege permission);

    /**
     * Check whether or not this player can hit another player.
     *
     * Players cannot hit each other if one of the followings is true:
     * 1) They are inside an island that has pvp disabled.
     * 2) One of them has pvp warm-up.
     * 3) They are both in the same island, and they hit each other outside of a pvp world.
     * 4) One of the players isn't online (duh?)
     * 5) The target player is inside an island as a visitor and can't take damage.
     * 6) The target player is inside an island as a coop and can't take damage.
     *
     * @param other The other player to check.
     */
    HitActionResult canHit(SuperiorPlayer other);

    /*
     *   Location Methods
     */

    /**
     * Get the world that the player is inside.
     */
    World getWorld();

    /**
     * Get the location of the player.
     */
    Location getLocation();

    /**
     * Teleport the player to a location.
     * @param location The location to teleport the player to.
     */
    void teleport(Location location);

    /**
     * Teleport the player to a location.
     * @param location The location to teleport the player to.
     * @param teleportResult The result of the teleportation process. May be null.
     */
    void teleport(Location location, Consumer<Boolean> teleportResult);

    /**
     * Teleport the player to an island.
     * @param island The island to teleport the player to.
     */
    void teleport(Island island);

    /**
     * Teleport the player to an island.
     * @param island The island to teleport the player to.
     * @param result Consumer that will be ran when task is finished.
     */
    void teleport(Island island, Consumer<Boolean> result);

    /**
     * Check whether or not the player is inside their island.
     */
    boolean isInsideIsland();

    /*
     *   Island Methods
     */

    /**
     * Get the island owner of the player's island.
     *
     * @deprecated getIslandLeader
     */
    @Deprecated
    UUID getTeamLeader();

    /**
     * Get the island owner of the player's island.
     */
    SuperiorPlayer getIslandLeader();

    /**
     * Set the island owner of the player's island.
     * !Can cause issues if not used properly!
     * @param teamLeader The island owner's uuid.
     *
     * @deprecated See setIslandLeader(SuperiorPlayer)
     */
    @Deprecated
    void setTeamLeader(UUID teamLeader);

    /**
     * Set the island owner of the player's island.
     * !Can cause issues if not used properly!
     * @param superiorPlayer The island owner's player.
     */
    void setIslandLeader(SuperiorPlayer superiorPlayer);

    /**
     * Get the island of the player.
     */
    Island getIsland();

    /**
     * Get the role of the player.
     */
    PlayerRole getPlayerRole();

    /**
     * Set the role of the player.
     * @param playerRole The role to give the player.
     */
    void setPlayerRole(PlayerRole playerRole);

    /**
     * Get the amount of left disbands.
     */
    int getDisbands();

    /**
     * Check whether or not the player has more disbands.
     */
    boolean hasDisbands();

    /**
     * Check whether or not the player has a permission.
     */
    void setDisbands(int disbands);

    /*
     *   Preferences Methods
     */

    /**
     * Get the locale of the player.
     */
    Locale getUserLocale();

    /**
     * Set the locale of the player.
     * @param locale The locale to set.
     */
    void setUserLocale(Locale locale);

    /**
     * Check whether or not the world border is enabled for the player.
     */
    boolean hasWorldBorderEnabled();

    /**
     * Toggle the world border for the player.
     */
    void toggleWorldBorder();

    /**
     * Check whether or not the blocks stacker mode is enabled for the player.
     */
    boolean hasBlocksStackerEnabled();

    /**
     * Toggle the blocks stacker for the player.
     */
    void toggleBlocksStacker();

    /**
     * Check whether or not the schematic mode is enabled for the player.
     */
    boolean hasSchematicModeEnabled();

    /**
     * Toggle the schematic mode for the player.
     */
    void toggleSchematicMode();

    /**
     * Check whether or not the team chat is enabled for the player.
     */
    boolean hasTeamChatEnabled();

    /**
     * Toggle the team chat for the player.
     */
    void toggleTeamChat();

    /**
     * Check whether or not the bypass mode is enabled for the player.
     */
    boolean hasBypassModeEnabled();

    /**
     * Toggle the bypass mode for the player.
     */
    void toggleBypassMode();

    /**
     * Check whether or not the player has their panel toggled.
     */
    boolean hasToggledPanel();

    /**
     * Set whether or not the player has their panel toggled.
     */
    void setToggledPanel(boolean toggledPanel);

    /**
     * Set whether or not the player has flying enabled.
     */
    boolean hasIslandFlyEnabled();

    /**
     * Toggle flying mode.
     */
    void toggleIslandFly();

    /**
     * Check whether or not the player has admin spy mode enabled.
     */
    boolean hasAdminSpyEnabled();

    /**
     * Toggle admin spy mode.
     */
    void toggleAdminSpy();

    /**
     * Get the border color of the player.
     */
    BorderColor getBorderColor();

    /**
     * Set the border color for the player.
     * @param borderColor The color to set.
     */
    void setBorderColor(BorderColor borderColor);

    /*
     *   Schematics Methods
     */

    /**
     * Get the first schematic position of the player. May be null.
     */
    BlockPosition getSchematicPos1();

    /**
     * Set the first schematic position of the player.
     * @param block The block to change the position to.
     */
    void setSchematicPos1(Block block);

    /**
     * Get the second schematic position of the player. May be null.
     */
    BlockPosition getSchematicPos2();

    /**
     * Set the second schematic position of the player.
     * @param block The block to change the position to.
     */
    void setSchematicPos2(Block block);

    /*
     *   Missions Methods
     */

    /**
     * Complete a mission.
     * @param mission The mission to complete.
     */
    void completeMission(Mission<?> mission);

    /**
     * Reset a mission.
     * @param mission The mission to reset.
     */
    void resetMission(Mission<?> mission);

    /**
     * Check whether the player has completed the mission before.
     * @param mission The mission to check.
     */
    boolean hasCompletedMission(Mission<?> mission);

    /**
     * Check whether the player can complete a mission again.
     * @param mission The mission to check.
     */
    boolean canCompleteMissionAgain(Mission<?> mission);

    /**
     * Get the amount of times mission was completed.
     * @param mission The mission to check.
     */
    int getAmountMissionCompleted(Mission<?> mission);

    /**
     * Get the list of the completed missions of the player.
     */
    List<Mission<?>> getCompletedMissions();

    /**
     * Get all the completed missions with the amount of times they were completed.
     */
    Map<Mission<?>, Integer> getCompletedMissionsWithAmounts();

    /*
     *   Data Methods
     */

    /**
     * Merge another player into this object.
     */
    void merge(SuperiorPlayer other);

    /**
     * Get the data handler of the object.
     */
    PlayerDataHandler getDataHandler();

}
