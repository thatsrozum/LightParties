package com.github.thatsrozum

import com.github.thatsrozum.api.LightPartiesAPI
import com.github.thatsrozum.impl.InvitationManagerImpl
import com.github.thatsrozum.impl.PartyManagerImpl
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    private val partyManager = PartyManagerImpl()
    private val invitationManager = InvitationManagerImpl()

    private lateinit var api: LightPartiesAPI

    override fun onEnable() {
        api = object : LightPartiesAPI {
            override fun invitationManager() = invitationManager
            override fun partyManager() = partyManager
        }

        server.servicesManager.register(
            LightPartiesAPI::class.java,
            api,
            this,
            ServicePriority.Normal
        )
    }
}
