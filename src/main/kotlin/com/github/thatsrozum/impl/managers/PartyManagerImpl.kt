package com.github.thatsrozum.impl.managers

import com.github.thatsrozum.api.managers.PartyManager
import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party
import com.github.thatsrozum.impl.objects.PartyImpl
import org.bukkit.entity.Player

/**
 * @suppress
 */
class PartyManagerImpl : PartyManager {
    private val partiesInternal = mutableSetOf<Party>()
    private val memberToParty = mutableMapOf<Member, Party>()

    override val parties
        get() = partiesInternal.toSet()

    override fun create(creator: Player): Boolean {
        val member = Member(creator)
        if (exists(member)) return false
        val party = PartyImpl(member, this)

        partiesInternal.add(party)
        memberToParty[member] = party

        return true
    }

    override fun disband(leader: Member): Boolean {
        val party = get(leader) ?: return false
        if (party.leader != leader) return false

        partiesInternal.remove(party)
        party.members.forEach { memberToParty.remove(it) }

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
