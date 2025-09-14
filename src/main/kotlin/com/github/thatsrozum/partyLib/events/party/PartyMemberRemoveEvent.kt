package com.github.thatsrozum.partyLib.events.party

import com.github.thatsrozum.partyLib.api.objects.Member
import com.github.thatsrozum.partyLib.api.objects.Party
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Called when a member is about to be removed from a party.
 *
 * This event is fired before removing the member from a party.
 *
 * @property member The member which will be removed.
 * @property party The party from which player will be removed.
 * @property reason The reason why member will be removed.
 *
 * ### Reasons
 * - [Reason.GENERIC] — A default, non-specific removal reason.
 * - [Reason.DISBAND] — The member was removed because the party got disbanded.
 */
class PartyMemberRemoveEvent(
    val member: Member,
    val party: Party,
    val reason: Reason
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList

    /**
     * The reason why a member was removed from a party
     */
    enum class Reason {
        /** Generic removal reason (eg., manual revoke). */
        GENERIC,

        /** The member was removed because the party got disbanded. */
        DISBAND
    }
}