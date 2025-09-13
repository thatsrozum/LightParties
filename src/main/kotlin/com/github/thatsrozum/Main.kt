package com.github.thatsrozum

import com.github.thatsrozum.api.LightPartiesAPI
import com.github.thatsrozum.impl.InvitationManagerImpl
import com.github.thatsrozum.impl.PartyManagerImpl
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.java.JavaPlugin

/**
 * @suppress
 */
class Main : JavaPlugin() {
    private val partyManager = PartyManagerImpl()
    private val invitationManager = InvitationManagerImpl()

    private lateinit var api: LightPartiesAPI

    override fun onEnable() {

        // Initialize API
        api = object : LightPartiesAPI {
            override fun getInvitationManager() = invitationManager
            override fun getPartyManager() = partyManager
        }

        // Register service object inside services manager
        server.servicesManager.register(
            LightPartiesAPI::class.java,
            api,
            this,
            ServicePriority.Normal
        )
    }
}
