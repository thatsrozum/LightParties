package com.github.thatsrozum.events.invitation

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import java.util.UUID

/**
 * This event is fired before removing the member from a party.
 *
 * @property inviter The inviter of the invitation that will be removed.
 * @property invitee The invitee of the invitation that will be removed.
 * @property reason The reason why member will be removed.
 * @property Reason.GENERIC - the generic reason of this event.
 * @property Reason.EXPIRATION - fired with this reason when the invitation expirates.
 */
class InvitationRemoveEvent(
    val inviter: UUID,
    val invitee: UUID,
    val reason: Reason
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList

    enum class Reason {
        GENERIC, EXPIRATION
    }
}