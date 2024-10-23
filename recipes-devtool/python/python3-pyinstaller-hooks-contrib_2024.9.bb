
SUMMARY = "Community maintained hooks for PyInstaller"
HOMEPAGE = "https://github.com/pyinstaller/pyinstaller-hooks-contrib"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

inherit pypi setuptools3

SRC_URI[sha256sum] = "4793869f370d1dc4806c101efd2890e3c3e703467d8d27bb5a3db005ebfb008d"

RDEPENDS_${PN} = "python3-setuptools python3-packaging"

S = "${WORKDIR}/pyinstaller_hooks_contrib-2024.9"

PYPI_ARCHIVE_NAME = "pyinstaller_hooks_contrib-2024.9.${PYPI_PACKAGE_EXT}"

BBCLASSEXTEND = "native nativesdk"
