package com.github.thatsrozum.partyLib.api.objects

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.UUID

/**
 * Represents a member of a [Party].
 *
 * A Member has a reference to a Bukkit Player object and their unique ID ([java.util.UUID]).
 *
 * @property player The Bukkit Player object associated with this member.
 * @property uniqueId The unique identifier of this member.
 */
class Member {
    val player: Player
    val uniqueId: UUID

    /**
     * Creates a [Member] from a Bukkit Player object.
     *
     * @param player the Bukkit Player representing this member
     */
    constructor(player: Player) {
        this.uniqueId = player.uniqueId
        this.player = player
    }

    /**
     * Creates a [Member] from a player's unique ID.
     *
     * This constructor will attempt to fetch the Player from Bukkit.
     * If the player is not online, this constructor will throw an [IllegalArgumentException].
     *
     * @param uniqueId the [UUID] of the player
     * @throws IllegalArgumentException if the player is not currently online
     */
    constructor(uniqueId: UUID) {
        val player: Player? = Bukkit.getPlayer(uniqueId)
        require(player != null) { "Player with UUID $uniqueId is not online" }

        this.uniqueId = uniqueId
        this.player = player
    }
}