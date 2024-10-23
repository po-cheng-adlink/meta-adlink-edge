
SUMMARY = "Python graph (network) package"
HOMEPAGE = "https://altgraph.readthedocs.io"
AUTHOR = "Ronald Oussoren <ronaldoussoren@mac.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "1b5afbb98f6c4dcadb2e2ae6ab9fa994bbb8c1d75f4fa96d340f9437ae454406"

S = "${WORKDIR}/altgraph-0.17.4"

RDEPENDS_${PN} = ""

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
