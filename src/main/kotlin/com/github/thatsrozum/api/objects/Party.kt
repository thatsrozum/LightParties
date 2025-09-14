package com.github.thatsrozum.api.objects


import com.github.thatsrozum.events.party.PartyMemberRemoveEvent

/**
 * Represents a party.
 *
 * @property leader The leader of the party.
 * @property members A copy of the members set.
 */
interface Party {
    val leader: Member
    val members: Set<Member>

    /**
     * Changes the leader of the party.
     *
     * @param newLeader the member to become the new leader
     * @return `the previous leader` if the change was successful, or `null` if the member is not part of the party
     */
    fun changeLeader(newLeader: Member): Member?

    /**
     * Adds a member to the party.
     *
     * @param member the member to add
     * @return `true` if the member was added, `false` if already in the party
     */
    fun addMember(member: Member): Boolean

    /**
     * Removes a member from the party.
     *
     * @param member the member to remove
     * @param reason the reason of removal
     * @return `true` if the member was removed, `false` if the member was not in the party
     */
    fun removeMember(member: Member, reason: PartyMemberRemoveEvent.Reason): Boolean

    /**
     * Removes a member from the party. Reason defaults to [PartyMemberRemoveEvent.Reason.GENERIC]
     *
     * @param member the member to remove
     * @return `true` if the member was removed, `false` if the member was not in the party
     */
    fun removeMember(member: Member): Boolean

    /**
     * Checks if a member is part of this party.
     *
     * @param member the member to check
     * @return `true` if the member is in this party, `false` otherwise
     */
    fun hasMember(member: Member): Boolean
}