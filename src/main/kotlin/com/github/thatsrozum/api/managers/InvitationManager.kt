package com.github.thatsrozum.api.managers

import org.bukkit.entity.Player
import java.util.UUID

/**
 * Manages invitations and temporarily stores them in the plugin's cache.
 *
 * This is a utility interface for sending, checking, and removing invitations.
 */
interface InvitationManager {

    /**
     * Sends an invitation from [inviter] to [invitee].
     *
     * @param inviter the Bukkit Player sending the invitation
     * @param invitee the Bukkit Player receiving the invitation
     * @param delay the delay (in milliseconds) after which the invitation will be automatically removed.
     *              If delay < 0, the invitation will not be scheduled for removal.
     */
    fun send(inviter: Player, invitee: Player, delay: Long)

    /**
     * Removes an invitation from [inviter] to [invitee].
     *
     * @param inviter the Bukkit Player who sent the invitation
     * @param invitee the Bukkit Player who received the invitation
     * @return `true` if the invitation was removed successfully, `false` if it did not exist
     */
    fun remove(inviter: Player, invitee: Player): Boolean

    /**
     * Removes an invitation from [inviter] to [invitee] using UUIDs.
     *
     * @param inviter the [java.util.UUID] of the Bukkit Player who sent the invitation
     * @param invitee the [java.util.UUID] of the Bukkit Player who received the invitation
     * @return `true` if the invitation was removed successfully, `false` if it did not exist
     */
    fun remove(inviter: UUID, invitee: UUID): Boolean

    /**
     * Checks if an invitation from [inviter] to [invitee] exists.
     *
     * @param inviter the Bukkit Player who sent the invitation
     * @param invitee the Bukkit Player who received the invitation
     * @return `true` if the invitation exists, `false` otherwise
     */
    fun exists(inviter: Player, invitee: Player): Boolean

    /**
     * Checks if an invitation from [inviter] to [invitee] exists using UUIDs.
     *
     * @param inviter the [UUID] of the Bukkit Player who sent the invitation
     * @param invitee the [UUID] of the Bukkit Player who received the invitation
     * @return `true` if the invitation exists, `false` otherwise
     */
    fun exists(inviter: UUID, invitee: UUID): Boolean
}