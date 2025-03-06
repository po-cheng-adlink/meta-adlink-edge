SUMMARY = "A microframework based on Werkzeug, Jinja2 and good intentions"
DESCRIPTION = "\
Flask is a microframework for Python based on Werkzeug, Jinja 2 and good \
intentions. And before you ask: It’s BSD licensed!"
HOMEPAGE = "https://github.com/mitsuhiko/flask/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=ffeffa59c90c9c4a033c7574f8f3fb75"

SRC_URI[sha256sum] = "7eb373984bf1c770023fce9db164ed0c3353cd0b53f130f4693da0ca756a2e6d"

PYPI_PACKAGE = "Flask"

inherit pypi setuptools3

CLEANBROKEN = "1"

RDEPENDS:${PN} = " \
    ${PYTHON_PN}-werkzeug (>= 2.2.0) \
    ${PYTHON_PN}-jinja2 (>= 1.11.0) \
    ${PYTHON_PN}-itsdangerous (>= 2.1.0) \
    ${PYTHON_PN}-click (>= 8.1.3) \
    ${PYTHON_PN}-profile \
"
