SUMMARY = "EdgeGo is a software platform for ADLINK distributed device management"
HOMEPAGE = "https://www.adlinktech.com/tw/News_23110814280423873"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
SRCSERVER = "git://GitLab.Adlinktech.com/SEC_IST_CROSS_TEAM/edgego-agent.git"
SRCBRANCH = "main"
SRCOPTIONS = ";protocol=http"
SRCOPTIONS:append:private = ";user=${PRIVATE_USER}:${PRIVATE_TOKEN}"
SRCREV = "caedfb60d0a5e1ba7b43343dab3177f6dd873476"
SRC_URI = "${SRCSERVER};branch=${SRCBRANCH}${SRCOPTIONS}"

inherit python3-dir setuptools3

S = "${WORKDIR}/git/devicegosdk"

RDEPENDS:${PN} += " \
        python3-apscheduler \
        python3-pillow \
        python3-psutil \
        python3-pyautogui \
        python3-pyyaml \
        python3-setuptools \
        python3-tzlocal \
        python3-zeroconf \
        python3-packaging \
        python3-pysmart \
        python3-pytz \
        python3-pika \
        smartmontools \
"
#
# NOTE: Remove dependency to python3-twisted from python3-pika for now. As we are not using python3-twisted.
#
