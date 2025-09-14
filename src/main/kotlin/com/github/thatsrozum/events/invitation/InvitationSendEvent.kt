package com.github.thatsrozum.events.invitation

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Called when an invitation is about to be sent.
 *
 * This event is fired right before storing the invitation.
 *
 * @property inviter The Bukkit Player who is the sender of the invitation.
 * @property invitee The Bukkit Player who is receiver of the invitation.
 * @property delay The delay of the invitation after which the invitation will remove itself,
 *                 `If delay < 0` the invitation will not be scheduled for removal
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