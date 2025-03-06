SUMMARY = "Simple WebSocket server and client for Python"
DESCRIPTION = "Simple WebSocket server and client for Python."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "7939234e7aa067c534abdab3a9ed933ec9ce4691b0713c78acb195560aa52ae4"

inherit pypi setuptools3

PYPI_ARCHIVE_NAME = "simple_websocket-${PV}.${PYPI_PACKAGE_EXT}"
S = "${WORKDIR}/simple_websocket-${PV}"

do_configure:prepend() {
    cat > ${S}/setup.py <<EOF
from setuptools import setup

setup(
    name="${PYPI_PACKAGE}",
    version="${PV}",
    license="${LICENSE}",
    packages=["simple_websocket"],
)
EOF
    cp -rf ${S}/src/simple_websocket ${S}
}

RDEPENDS:${PN} += " \
	python3-wsproto \
"
