package com.carterharrison.ecdsa

import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * Elliptic Curve Diffie–Hellman Key Exchange
 */
object EcDhKeyAgreement {

  fun keyAgreement(privateKeyPair: EcKeyPair, publicKey: EcPoint): EcPoint {
    return keyAgreement(privateKeyPair.privateKey, publicKey)
  }

  fun keyAgreement(privateKey: BigInteger, publicKey: EcPoint): EcPoint {
    return publicKey.times(privateKey)
  }

}