SUMMARY = "Wrapper for smartctl (smartmontools)"
DESCRIPTION = "pySMART is a simple Python wrapper for the smartctl component of smartmontools. It is officially compatible with Linux, Windows and FreeBSD, as long as smartctl is on the system path. Running with administrative rights is strongly recommended, as smartctl cannot accurately detect all device types or parse all SMART information without these permissions."

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.1-or-later;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

SRC_URI[sha256sum] = "43f5e049957bdd80f181ae88223c0a2bdbe38181f241be21160d4c4b51c87365"

inherit pypi setuptools3

PYPI_PACKAGE = "pySMART"

do_configure:prepend() {
    cat > ${S}/setup.py <<EOF
from setuptools import setup

setup(
    name="${PYPI_PACKAGE}",
    version="${PV}",
    license="${LICENSE}",
    packages=["pySMART", "pySMART/interface", "pySMART/interface/ata", "pySMART/interface/nvme"],
)
EOF
}

DEPENDS += " \
	python3-pdm \
	python3-pdm-backend-native \
	python3-setuptools-scm-native \
"
