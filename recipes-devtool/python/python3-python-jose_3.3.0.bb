SUMMARY = "JOSE implementation in Python"
DESCRIPTION = "The JavaScript Object Signing and Encryption (JOSE) technologies - JSON Web Signature (JWS), JSON Web Encryption (JWE), JSON Web Key (JWK), and JSON Web Algorithms (JWA) - collectively can be used to encrypt and/or sign content using a variety of algorithms. While the full set of permutations is extremely large, and might be daunting to some, it is expected that most applications will only use a small set of algorithms to meet their needs."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "55779b5e6ad599c6336191246e95eb2293a9ddebd555f796a65f838f07e5d78a"

inherit pypi python_poetry_core

DEPENDS += " \
        python3-pdm-native \
        python3-pdm-backend-native \
	python3-pytest-runner-native \
"
