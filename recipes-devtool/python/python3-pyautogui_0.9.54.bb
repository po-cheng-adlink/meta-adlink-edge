SUMMARY = "PyAutoGUI lets Python control the mouse and keyboard, and other GUI automation tasks"
DESCRIPTION = "PyAutoGUI is a cross-platform GUI automation Python module for human beings. Used to programmatically control the mouse & keyboard."

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI[sha256sum] = "dd1d29e8fd118941cb193f74df57e5c6ff8e9253b99c7b04f39cfc69f3ae04b2"

inherit pypi python_poetry_core

PYPI_PACKAGE = "PyAutoGUI"

DEPENDS += " \
	python3-pdm-native \
	python3-pdm-backend-native \
"
