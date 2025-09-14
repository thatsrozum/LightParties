package com.github.thatsrozum.partyLib.impl.managers

import com.github.thatsrozum.partyLib.api.managers.PartyManager
import com.github.thatsrozum.partyLib.api.objects.Member
import com.github.thatsrozum.partyLib.api.objects.Party
import com.github.thatsrozum.partyLib.events.party.PartyMemberRemoveEvent
import com.github.thatsrozum.partyLib.events.party.management.PartyCreateEvent
import com.github.thatsrozum.partyLib.events.party.management.PartyDisbandEvent
import com.github.thatsrozum.partyLib.impl.objects.PartyImpl
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

/**
 * @suppress
 */
class PartyManagerImpl(private val plugin: JavaPlugin) : PartyManager {
    private val partiesInternal = mutableSetOf<Party>()
    private val memberToParty = mutableMapOf<Member, Party>()

    override val parties
        get() = partiesInternal.toSet()

    override fun create(creator: Player): Boolean {
        val member = Member(creator)
        if (exists(member)) return false
        val party = PartyImpl(member, this, plugin)

        partiesInternal.add(party)
        memberToParty[member] = party

        val event = PartyCreateEvent(member, party)
        plugin.server.pluginManager.callEvent(event)

        return true
    }

    override fun disband(leader: Member): Boolean {
        val party = get(leader) ?: return false
        if (party.leader != leader) return false

        val event = PartyDisbandEvent(leader, party)
        plugin.server.pluginManager.callEvent(event)

        party.members.forEach {
            party.removeMember(it, PartyMemberRemoveEvent.Reason.DISBAND)
            memberToParty.remove(it)
        }
        partiesInternal.remove(party)

        return true
    }

    override fun get(member: Member): Party? = memberToParty[member]

    override fun exists(member: Member): Boolean = member in memberToParty

    override fun isLeader(member: Member): Boolean = memberToParty[member]?.leader == member

    // Internal functions used by PartyImpl class

    internal fun onMemberAdded(partyImpl: PartyImpl, member: Member) {
        memberToParty[member] = partyImpl
    }

    internal fun onMemberRemoved(member: Member) {
        memberToParty.remove(member)
    }
}
