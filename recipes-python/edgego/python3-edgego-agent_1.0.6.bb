SUMMARY = "EdgeGo is a software platform for ADLINK distributed device management"
HOMEPAGE = "https://www.adlinktech.com/tw/News_23110814280423873"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
SRCSERVER = "git://github.com/adlink-edgego/edgego-agent.git"
SRCBRANCH = "main"
SRCOPTIONS = ";protocol=https"
SRCOPTIONS:append:private = ";user=${PRIVATE_USER}:${PRIVATE_TOKEN}"
SRCREV = "a1d0d083081ffb90e96410512f5f0ba44c4ee86a"
SRC_URI = "${SRCSERVER};branch=${SRCBRANCH}${SRCOPTIONS}"

inherit python3-dir python_poetry_core

S = "${WORKDIR}/git/agent"

DEPENDS += " \
	python3-pdm-native \
	python3-pdm-backend-native \
"

RDEPENDS:${PN} += " \
	python3-flask \
	python3-flask-socketio \
	python3-pycryptodome \
	python3-cryptography \
	python3-pamela \
	python3-comtypes \
	python3-pycaw \
	python3-requests \
	python3-pyyaml \
	python3-zeroconf \
	python3-watchdog \
"

