SUMMARY = "EGiFlow is a software platform for ADLINK device management"
HOMEPAGE = "https://www.adlinktech.com/tw/News_23110814280423873"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
SRCSERVER = "git://GitLab.Adlinktech.com/SEC_IST_CROSS_TEAM/emu_middleware.git"
SRCBRANCH = "sp2-demo"
SRCOPTIONS = ";protocol=http"
SRCOPTIONS:append:private = ";user=${PRIVATE_USER}:${PRIVATE_TOKEN}"
SRCREV = "7aac0e08b925234864ed84099522b80428a6d77e"
SRC_URI = "${SRCSERVER};branch=${SRCBRANCH}${SRCOPTIONS}"

inherit python3-dir python_poetry_core

S = "${WORKDIR}/git/emu_core"

DEPENDS += " \
	python3-pdm-native \
	python3-pdm-backend-native \
"

RDEPENDS:${PN} += " \
	python3-jinja2 \
	python3-loguru \
	python3-psutil \
	python3-pytz \
"

