package com.github.thatsrozum.events.invitation

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * This event is fired before removing the member from a party.
 *
 * @property inviter The Bukkit Player inviter of the invitation that will be removed.
 * @property invitee The Bukkit Player invitee of the invitation that will be removed.
 * @property delay the delay (in milliseconds) after which the invitation will be automatically removed.
 *                 `If delay < 0`, the invitation will not be scheduled for removal.
 */
class InvitationSendEvent(
    val inviter: Player,
    val invitee: Player,
    val delay: Long
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers() = handlerList
}