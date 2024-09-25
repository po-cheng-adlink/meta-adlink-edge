SUMMARY = "FastAPI framework, high performance, easy to learn, fast to code, ready for production"
DESCRIPTION = "FastAPI is a modern, fast (high-performance), web framework for building APIs with Python based on standard Python type hints."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "0adb148b62edb09e8c6eeefa3ea934e8f276dabc038c5a82989ea6346050c3da"

inherit pypi python_poetry_core

DEPENDS += " \
        python3-pdm-native \
        python3-pdm-backend-native \
"
