package com.github.thatsrozum.partyLib.events.invitation

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import java.util.UUID

/**
 * Called when an invitation is about to be removed.
 *
 * This event is fired right before the removal happens.
 *
 * @property inviter The [UUID] of the Bukkit Player who originally sent the invitation.
 * @property invitee The [UUID] of the Bukkit Player who received the invitation.
 * @property reason The reason why this invitation is being removed.
 *
 * ### Reasons
 * - [Reason.GENERIC] — A default, non-specific removal reason.
 * - [Reason.EXPIRATION] — The invitation expired naturally without being accepted.
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

    /**
     * The reason why an invitation was removed.
     */
    enum class Reason {
        /** Generic removal reason (eg., manual revoke). */
        GENERIC,

        /** The invitation expired without being accepted. */
        EXPIRATION
    }
}