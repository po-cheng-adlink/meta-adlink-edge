SUMMARY = "PAM interface using ctypes"
DESCRIPTION = "Pamela: yet another Python wrapper for PAM"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "0ea6e2a99dded8c7783a4a06f2d31f5bdcad894d79101e8f09322e387a34aacf"

inherit pypi python_poetry_core

DEPENDS += " \
	python3-pdm-native \
	python3-pdm-backend-native \
"
