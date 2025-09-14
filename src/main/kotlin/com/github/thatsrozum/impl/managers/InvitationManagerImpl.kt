package com.github.thatsrozum.impl.managers

import com.github.thatsrozum.api.managers.InvitationManager
import org.bukkit.entity.Player
import java.util.Timer
import java.util.TimerTask
import java.util.UUID
import kotlin.concurrent.schedule

/**
 * @suppress
 */
class InvitationManagerImpl : InvitationManager {
    private val invitations = mutableMapOf<UUID, MutableSet<UUID>>()
    private val schedules = mutableMapOf<Pair<UUID, UUID>, TimerTask>() // Pair's first = inviter, second = invitee

    override fun send(inviter: Player, invitee: Player, delay: Long) {
        invitations.computeIfAbsent(invitee.uniqueId) { mutableSetOf() }.add(inviter.uniqueId)

        cancelSchedule(inviter.uniqueId, invitee.uniqueId)

        if (delay < 0) { // If the delay is less than 0 don't schedule removal of the invitation
            return
        }

        val schedule = Timer().schedule(delay) { remove(inviter, invitee) }
        schedules[Pair(inviter.uniqueId, invitee.uniqueId)] = schedule
    }

    override fun remove(inviter: Player, invitee: Player) : Boolean = remove(inviter.uniqueId, invitee.uniqueId)

    override fun remove(inviter: UUID, invitee: UUID) : Boolean {
        if (!exists(inviter, invitee)) return false

        invitations[invitee]?.remove(inviter) // Remove the inviter from invitee's invites
        cancelSchedule(inviter, invitee) // Remove the TimerTask from the map and cancel it if exists
        if (invitations[invitee]?.isEmpty() == true) {
            invitations.remove(invitee) // If the invitee doesn't have any invites remove them from a map
        }
        return true
    }

    override fun exists(inviter: Player, invitee: Player): Boolean = exists(inviter.uniqueId, invitee.uniqueId)

    override fun exists(inviter: UUID, invitee: UUID): Boolean = invitations[invitee]?.contains(inviter) == true

    private fun cancelSchedule(inviter: UUID, invitee: UUID) {
        val pair = Pair(inviter, invitee) // Transform these into a Pair object
        val timerTask = schedules.remove(pair) // Remove it from the map and get the timer task
        timerTask?.cancel() // Cancel the task if TimerTask isn't null
    }
}