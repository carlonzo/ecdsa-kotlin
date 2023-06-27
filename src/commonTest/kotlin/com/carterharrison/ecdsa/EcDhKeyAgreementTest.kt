package com.carterharrison.ecdsa

import com.carterharrison.ecdsa.curves.Secp256r1
import kotlin.test.Test
import kotlin.test.assertEquals

class EcDhKeyAgreementTest {

  @Test
  fun test1() {
    val alice = EcKeyGenerator.newInstance(Secp256r1)
    val bob = EcKeyGenerator.newInstance(Secp256r1)

    val keyAgreementAlice = EcDhKeyAgreement.keyAgreement(alice.privateKey, bob.publicKey)
    val keyAgreementBob = EcDhKeyAgreement.keyAgreement(bob.privateKey, alice.publicKey)

    assertEquals(keyAgreementAlice, keyAgreementBob)
  }

  @Test
  fun test2() {
    val alice = EcKeyGenerator.newInstance(Secp256r1)
    val bob = EcKeyGenerator.newInstance(Secp256r1)

    val keyAgreementAlice = EcDhKeyAgreement.keyAgreement(alice, bob.publicKey)
    val keyAgreementBob = EcDhKeyAgreement.keyAgreement(bob, alice.publicKey)

    assertEquals(keyAgreementAlice, keyAgreementBob)
  }
}