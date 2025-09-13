package com.github.thatsrozum.api

import org.bukkit.entity.Player

/**
 * Manages [Party] instances.
 */
interface PartyManager {

    /**
     * Creates a new party with the given player as leader.
     *
     * @param creator the player who will be the leader of the party
     * @return `true` if the party was created successfully, `false` if a party already exists for the player
     */
    fun create(creator: Player): Boolean

    /**
     * Disbands the party led by the given member.
     *
     * @param leader the member who is the party leader
     * @return `true` if the party was disbanded successfully, `false` if the member is not a leader or not in a party
     */
    fun disband(leader: Member): Boolean

    /**
     * Gets the party that contains the given member.
     *
     * @param member the member to look up
     * @return the `party` containing the member, or `null` if the member is not in any party
     */
    fun get(member: Member): Party?

    /**
     * Checks if the given member belongs to a party.
     *
     * @param member the member to check
     * @return `true` if the member is in a party, `false` otherwise
     */
    fun exists(member: Member): Boolean

    /**
     * Checks if the given member is the leader of their party.
     *
     * @param member the member to check
     * @return `true` if the member is a leader, `false` if not or if the member is not in any party
     */
    fun isLeader(member: Member): Boolean

    /**
     * Returns a copy of all stored parties.
     *
     * @return a copied set of all parties
     */
    fun getParties(): Set<Party>
}
