SUMMARY = "The build backend used by PDM that supports latest packaging standards"
HOMEPAGE = "https://github.com/pdm-project/pdm-backend"
LICENSE = "MIT"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a564297b3c5b629a528b92fd8ff61ea"

SRC_URI[sha256sum] = "2487dfbd13f69d80fb4e6a08006a3ee68272833970813047dc5fcfacdfdc0151"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE= "pdm_backend"

do_configure:prepend() {
    cat > ${S}/setup.py <<EOF
from setuptools import setup

setup(
    name="${PYPI_PACKAGE}",
    version="${PV}",
    license="${LICENSE}",
    packages=["pdm", "pdm/backend", "pdm/backend/hooks", "pdm/backend/hooks/version", "pdm/backend/_vendor", "pdm/backend/_vendor/packaging", "pdm/backend/_vendor/pyproject_metadata", "pdm/backend/_vendor/tomli", "pdm/backend/_vendor/tomli_w"],
)
EOF
    cp -rf ${S}/src/pdm ${S}
}

BBCLASSEXTEND = "native nativesdk"
