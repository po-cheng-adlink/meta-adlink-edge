SUMMARY = "Python's filesystem abstraction layer"
DESCRIPTION = "Think of PyFilesystem's FS objects as the next logical step to Python's file objects. In the same way that file objects abstract a single file, FS objects abstract an entire filesystem."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "ae97c7d51213f4b70b6a958292530289090de3a7e15841e108fbe144f069d313"

inherit pypi setuptools3

