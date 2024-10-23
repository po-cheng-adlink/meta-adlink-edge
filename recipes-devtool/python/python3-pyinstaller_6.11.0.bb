
SUMMARY = "PyInstaller bundles a Python application and all its dependencies into a single package."
HOMEPAGE = "https://www.pyinstaller.org/"
AUTHOR = "Hartmut Goebel, Giovanni Bajo, David Vierra, David Cortesi, Martin Zibricky <None>"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

SRC_URI[sha256sum] = "cb4d433a3db30d9d17cf5f2cf7bb4df80a788d493c1d67dd822dc5791d9864af"

S = "${WORKDIR}/pyinstaller-6.11.0"

RDEPENDS_${PN} = "python3-altgraph python3-pyinstaller-hooks-contrib"

inherit pypi setuptools3

INSANE_SKIP:${PN} += "already-stripped"

BBCLASSEXTEND = "native nativesdk"
