SUMMARY = "Pure Python COM package"
DESCRIPTION = "comtypes is a lightweight pure Python COM package based on the ctypes foreign function interface library."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit python3-dir python_poetry_core

WHL_BPN="${@ d.getVar('BPN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"
WHL_BP="${@ d.getVar('BP').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"
WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"

#
# download URL from PYPI:
# https://files.pythonhosted.org/packages/52/55/f2122be04a51f2c90764d37b83d420a8abc263ab81b2557f142324160b3a/comtypes-1.4.7.zip
#

SRC_URI = "https://files.pythonhosted.org/packages/52/55/f2122be04a51f2c90764d37b83d420a8abc263ab81b2557f142324160b3a/${WHL_BP}.zip"

SRC_URI[sha256sum] = "cc4f3cd5db28c6a0c9fce781720192c60b2f198e548fd6dfcfc1d47b6f8ea20f"

DEPENDS += "unzip-native"

do_copy_dir () {
  cp -rf ${WORKDIR}/${WHL_BP}/* ${WORKDIR}/python3-${WHL_BP}
}
addtask copy_dir before do_patch after do_unpack

