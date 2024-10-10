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
"
# FIXME: python3-pika requires python3-twisted but couldn't install in do_rootfs due to rdepends
#        so use pkg_postinst_ontarget() to pip3 install pika and twisted
#       python3-pika
