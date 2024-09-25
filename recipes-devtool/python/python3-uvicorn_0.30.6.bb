SUMMARY = "The lightning-fast ASGI server."
DESCRIPTION = "Uvicorn is an ASGI web server implementation for Python."
HOMEPAGE ="https://pypi.org/project/uvicorn"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI[sha256sum] = "4b15decdda1e72be08209e860a1e10e92439ad5b97cf44cc945fcbee66fc5788"

inherit pypi python_poetry_core
PYPI_PACKAGE = "uvicorn"

DEPENDS += " \
	python3-pdm-native \
	python3-pdm-backend-native \
	python3-hatchling-native \
"
