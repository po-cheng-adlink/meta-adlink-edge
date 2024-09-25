# Copyright 2021 ADLINK
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "ADLINK packagegroup for edgego and egiflow"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = " \
	packagegroup-edge \
	packagegroup-edgego \
	packagegroup-egiflow \
"

#
# packagegroup-edge contain stuff needed for adlink EdgeGo and EGiFlow
#
RDEPENDS:packagegroup-edge = " \
	packagegroup-edgego \
	packagegroup-egiflow \
"

#
# packages needed for adlink EGiFlow
#
SUMMARY:packagegroup-egiflow = "ADLINK EGiFlow Support"
RDEPENDS:packagegroup-egiflow = " \
    emu-web \
    python3-emu-core \
    python3-emu-rest \
    python3-emu-modbus \
"

#
# packages added by adlink EdgeGo
#
SUMMARY:packagegroup-edgego = "Adlink EdgeGo Support"
RDEPENDS:packagegroup-edgego = " \
    python3-edgego-agent \
"
