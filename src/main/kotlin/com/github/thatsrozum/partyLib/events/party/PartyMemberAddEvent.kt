package com.github.thatsrozum.partyLib.events.party

import com.github.thatsrozum.partyLib.api.objects.Member
import com.github.thatsrozum.partyLib.api.objects.Party
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Called when a member is about to be added to a party.
 *
 * This event is fired right before adding the member to a party.
 *
 * @property member The member which will be added.
 * @property party The party to which the member will be added.
 */
class PartyMemberAddEvent(
    val member: Member,
    val party: Party
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList
}