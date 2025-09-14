package com.github.thatsrozum.impl.objects

import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party
import com.github.thatsrozum.impl.managers.PartyManagerImpl

/**
 * @suppress
 */
class PartyImpl(override var leader: Member, private val partyManagerImpl: PartyManagerImpl) : Party {
    val membersInternal = mutableSetOf(leader)

    override val members: Set<Member>
        get() = membersInternal.toSet()

    override fun changeLeader(newLeader: Member): Member? {
        if (newLeader !in membersInternal) return null
        val oldLeader = leader
        leader = newLeader
        return oldLeader
    }

    override fun addMember(member: Member): Boolean {
        if (partyManagerImpl.exists(member)) return false

        membersInternal.add(member)
        partyManagerImpl.onMemberAdded(this, member)

        return true
    }

    override fun removeMember(member: Member): Boolean {
        if (!partyManagerImpl.exists(member)) return false

        membersInternal.remove(member)
        partyManagerImpl.onMemberRemoved(member)

        return true
    }

    override fun hasMember(member: Member): Boolean = member in membersInternal
}
