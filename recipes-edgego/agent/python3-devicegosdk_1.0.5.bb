SUMMARY = "EdgeGo is a software platform for ADLINK distributed device management"
HOMEPAGE = "https://www.adlinktech.com/tw/News_23110814280423873"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
SRCSERVER = "git://GitLab.Adlinktech.com/SEC_IST_CROSS_TEAM/edgego-agent.git"
SRCBRANCH = "dev"
SRCOPTIONS = ";protocol=http"
SRCOPTIONS:append:private = ";user=${PRIVATE_USER}:${PRIVATE_TOKEN}"
SRCREV = "55dcfd56f507b47259d0d89c1d643535e5cbb108"
SRC_URI = "${SRCSERVER};branch=${SRCBRANCH}${SRCOPTIONS}"

SRC_URI += " \
  file://0001-DeviceGoSDK-SmartCTLParser-parse-emmc-for-arm64.patch \
  file://0003-devicegosdk-TerminalManager.py-fix-subprocess.run-fo.patch \
  file://0004-DeviceGoSDK-frpc-fix-agent.ini-path.patch \
  file://0005-DeviceGoMission-Update-logs.patch \
"

inherit python3-dir setuptools3

S = "${WORKDIR}/git"
SETUPTOOLS_SETUP_PATH = "${WORKDIR}/git/devicegosdk"

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
