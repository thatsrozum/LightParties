package com.github.thatsrozum.partyLib

import com.github.thatsrozum.partyLib.api.PartyLibAPI
import com.github.thatsrozum.partyLib.impl.managers.InvitationManagerImpl
import com.github.thatsrozum.partyLib.impl.managers.PartyManagerImpl
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.java.JavaPlugin

/**
 * @suppress
 */
class PartyLibPlugin : JavaPlugin() {
    private val partyManager = PartyManagerImpl(this)
    private val invitationManager = InvitationManagerImpl(this)

    private lateinit var api: PartyLibAPI

    override fun onEnable() {

        // Initialize API
        api = object : PartyLibAPI {
            override fun getInvitationManager() = invitationManager
            override fun getPartyManager() = partyManager
        }

        // Register service object in services manager
        server.servicesManager.register(
            PartyLibAPI::class.java,
            api,
            this,
            ServicePriority.Normal
        )
    }
}