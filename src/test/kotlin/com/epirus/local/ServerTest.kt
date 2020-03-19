package com.epirus.local

import org.junit.Before
import org.junit.BeforeClass
import org.web3j.evm.EmbeddedEthereum
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ServerTest {

    private val server : Server

    init{
        server = Server()
    }

    @Test
    fun eth_blockNumberTest(){
        val response = server.makeCall(Request("2.0", "eth_blockNumber", listOf<String>(""), 1))
        assertEquals(response, "0x0000000000000000000000000000000000000000000000000000000000000000")
    }

    @Test
    fun eth_getBalanceTest(){
        val response = server.makeCall(Request("2.0", "eth_getBalance", listOf<String>("0xc94770007dda54cF92009BFF0dE90c06F603a09f", "latest"), 1))
        assertEquals(response, "0x0000000000000000000000000000000000000000000000008ac7230489e80000")
    }

    @Test
    fun eth_getTransactionCount(){
        val response = server.makeCall(Request("2.0", "eth_getTransactionCount", listOf<String>("0xc94770007dda54cF92009BFF0dE90c06F603a09f", "latest"), 1))
        assertEquals(response, BigInteger.ZERO)
    }

    @Test
    fun eth_estimateGasTest(){
        val transactionDetails = HashMap<String, String>()
        transactionDetails["from"] = "0xb60e8dd61c5d32be8058bb8eb970870f07233155"
        transactionDetails["to"] = "0xb60e8dd61c5d32be8058bb8eb970870f07233156"
        transactionDetails["gas"] = "0x341cd"
        transactionDetails["gasPrice"] = "0x3241431"
        transactionDetails["value"] = "0x3431cde"
        transactionDetails["nonce"] = "0x0"
        transactionDetails["data"] = "0xd46e8dd67c5d32be8d46e8dd67c5d32be8058bb8eb970870f072445675058bb8eb970870f072445675"

        val response = server.makeCall(Request("2.0", "eth_estimateGas", transactionDetails, 1))
        assertEquals(response, "0x00000000000000000000000000000000000000000000000000000000000341ce")
    }

    @Test
    fun eth_getBlockByNumber(){ // to be done after getting send transaction to work

    }

    @Test
    fun eth_getBlockByHash(){ // to be done after getting send transaction to work

    }
}
