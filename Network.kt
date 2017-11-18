package com.example.eoghan.soundmateapp
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

/**
 * Created by Eoghan on 18/11/17.
 */
class Network {
    val server_port = 1100
    val s = DatagramSocket()
    val local = InetAddress.getByName("127.0.0.1")
    fun send(message: String){
        val messageLength = message.length
        val messageBytes = message.toByteArray()
        val p = DatagramPacket(messageBytes, messageLength, local, server_port)
        s.send(p)
    }
}