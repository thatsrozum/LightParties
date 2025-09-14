package com.github.thatsrozum.impl.objects

import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party

/**
 * @suppress
 */
class PartyImpl(override var leader: Member) : Party {
    val membersInternal = mutableSetOf(leader)

    override val members: Set<Member>
        get() = membersInternal.toSet()

    override fun changeLeader(newLeader: Member): Member? {
        if (newLeader !in membersInternal) return null
        val oldLeader = leader
        leader = newLeader
        return oldLeader
    }

    override fun addMember(member: Member): Boolean = membersInternal.add(member)

    override fun removeMember(member: Member): Boolean = membersInternal.remove(member)

    override fun hasMember(member: Member): Boolean = membersInternal.contains(member)
}