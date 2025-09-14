package com.github.thatsrozum

import com.github.thatsrozum.api.PartyLibAPI
import com.github.thatsrozum.impl.managers.InvitationManagerImpl
import com.github.thatsrozum.impl.managers.PartyManagerImpl
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

        // Register service object inside services manager
        server.servicesManager.register(
            PartyLibAPI::class.java,
            api,
            this,
            ServicePriority.Normal
        )
    }
}
