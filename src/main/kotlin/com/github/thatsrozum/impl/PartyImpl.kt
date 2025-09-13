package com.github.thatsrozum.impl

import com.github.thatsrozum.api.Member
import com.github.thatsrozum.api.Party

/**
 * @suppress
 */
class PartyImpl(override var leader: Member) : Party {
    override val members = mutableSetOf(leader)

    override fun changeLeader(newLeader: Member): Member? {
        if (newLeader !in members) return null
        val oldLeader = leader
        leader = newLeader
        return oldLeader
    }

    override fun addMember(member: Member): Boolean = members.add(member)

    override fun removeMember(member: Member): Boolean = members.remove(member)

    override fun hasMember(member: Member): Boolean = members.contains(member)
}

