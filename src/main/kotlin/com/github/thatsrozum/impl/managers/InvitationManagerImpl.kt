package com.github.thatsrozum.impl.managers

import com.github.thatsrozum.api.managers.InvitationManager
import com.github.thatsrozum.events.invitation.InvitationRemoveEvent
import com.github.thatsrozum.events.invitation.InvitationSendEvent
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import kotlin.concurrent.schedule

/**
 * @suppress
 */
class InvitationManagerImpl(private val plugin: JavaPlugin) : InvitationManager {
    private val invitations = mutableMapOf<UUID, MutableSet<UUID>>()
    private val schedules = mutableMapOf<Pair<UUID, UUID>, TimerTask>() // Pair's first = inviter, second = invitee

    override fun send(inviter: Player, invitee: Player, delay: Long) {
        invitations.computeIfAbsent(invitee.uniqueId) { mutableSetOf() }.add(inviter.uniqueId)

        cancelSchedule(inviter.uniqueId, invitee.uniqueId)

        val event = InvitationSendEvent(inviter, invitee, delay)
        plugin.server.pluginManager.callEvent(event)

        // If the delay is less than 0 don't schedule removal of the invitation
        if (delay < 0) {
            return
        }

        val schedule = Timer().schedule(delay) { remove(inviter.uniqueId, invitee.uniqueId, InvitationRemoveEvent.Reason.EXPIRATION) }
        schedules[Pair(inviter.uniqueId, invitee.uniqueId)] = schedule
    }

    override fun remove(inviter: UUID, invitee: UUID, reason: InvitationRemoveEvent.Reason) : Boolean {
        if (!exists(inviter, invitee)) return false

        val event = InvitationRemoveEvent(inviter, invitee,  reason)
        plugin.server.pluginManager.callEvent(event)

        // Remove the inviter from invitee's invites
        invitations[invitee]?.remove(inviter)

        // Remove the TimerTask from the map and cancel it if exists
        cancelSchedule(inviter, invitee)
        if (invitations[invitee]?.isEmpty() == true) {
            // If the invitee doesn't have any invites remove them from a map
            invitations.remove(invitee)
        }

        return true
    }


    override fun exists(inviter: UUID, invitee: UUID): Boolean = invitations[invitee]?.contains(inviter) == true

    // Helper function to reduce duplicate lines of code

    private fun cancelSchedule(inviter: UUID, invitee: UUID) {
        // Transform these into a Pair object
        val pair = Pair(inviter, invitee)

        // Remove it from the map and get the timer task
        val timerTask = schedules.remove(pair)

        // Cancel the task if TimerTask isn't null
        timerTask?.cancel()
    }
}