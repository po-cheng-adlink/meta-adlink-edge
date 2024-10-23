SUMMARY = "EdgeGo is a software platform for ADLINK distributed device management"
HOMEPAGE = "https://www.adlinktech.com/tw/News_23110814280423873"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
SRCSERVER = "git://github.com/adlink-edgego/edgego-agent.git"
SRCBRANCH = "main"
SRCOPTIONS = ";protocol=https"
SRCOPTIONS:append:private = ";user=${PRIVATE_USER}:${PRIVATE_TOKEN}"
SRCREV = "a1d0d083081ffb90e96410512f5f0ba44c4ee86a"
SRC_URI = "${SRCSERVER};branch=${SRCBRANCH}${SRCOPTIONS}"

SRC_URI += "file://devgoupgrade.service"

#
# Following execution of buildLinuxPackage/build.sh, edgegoagent.deb edgegoupgrade.deb and vncservice.deb are generated
#
# edgego agent:
#
#	./opt/
#	./opt/edgego/
#	./opt/edgego/agent/
#	./opt/edgego/agent/Readme.txt
#	./opt/edgego/agent/agent/
#	./opt/edgego/agent/agent/agent							# python3 -m PyInstaller -F ../agent/agent.py
#	./opt/edgego/agent/agent/agent.ini
#	./opt/edgego/agent/agent/libs/
#	./opt/edgego/agent/agent/libs/pcie_dll_x64.so			# cp devicegosdk/devicegosdk/devicegosdktools/libs/pcie_dll_x64.so edgegoagent/opt/edgego/agent/agent/libs
#	./opt/edgego/agent/agent/libs/pcie_dll_x86.so			# cp devicegosdk/devicegosdk/devicegosdktools/libs/pcie_dll_x86.so edgegoagent/opt/edgego/agent/agent/libs
#	./opt/edgego/agent/agent/public.pem						# key for signing
#	./opt/edgego/agent/agent/root/
#	./opt/edgego/agent/agent/scheduler/
#	./opt/edgego/agent/agent/scheduler/cpu					# python3 -m PyInstaller -F ../scheduler/cpu.py
#	./opt/edgego/agent/agent/scheduler/hdd					# python3 -m PyInstaller -F ../scheduler/hdd.py
#	./opt/edgego/agent/agent/scheduler/heartbeat			# python3 -m PyInstaller -F ../scheduler/heartbeat.py
#	./opt/edgego/agent/agent/scheduler/mem					# python3 -m PyInstaller -F ../scheduler/mem.py
#	./opt/edgego/agent/agent/scheduler/network				# python3 -m PyInstaller -F ../scheduler/network.py
#	./opt/edgego/agent/agent/scheduler/scheduler.ini
#	./opt/edgego/agent/agent/scheduler/signature.cpu
#	./opt/edgego/agent/agent/scheduler/signature.hdd
#	./opt/edgego/agent/agent/scheduler/signature.heartbeat
#	./opt/edgego/agent/agent/scheduler/signature.mem
#	./opt/edgego/agent/agent/scheduler/signature.network
#	./opt/edgego/agent/agent/signature.agent
#	./opt/edgego/agent/agent/signature.terminal
#	./opt/edgego/agent/agent/signature.vnc_indicator
#	./opt/edgego/agent/agent/terminal						# python3 -m PyInstaller --collect-all socketio --collect-all engineio --collect-all flask_socketio -F ../agent/terminal.py
#	./opt/edgego/agent/agent/terminalfolder/
#	./opt/edgego/agent/agent/terminalfolder/static/			# cp -r agent/terminalfolder/static edgegoagent/opt/edgego/agent/agent/terminalfolder
#	./opt/edgego/agent/agent/terminalfolder/static/index.html
#	./opt/edgego/agent/agent/terminalfolder/static/socket.io.min.js
#	./opt/edgego/agent/agent/terminalfolder/static/xterm-addon-fit.js
#	./opt/edgego/agent/agent/terminalfolder/static/xterm-addon-search.js
#	./opt/edgego/agent/agent/terminalfolder/static/xterm-addon-web-links.js
#	./opt/edgego/agent/agent/terminalfolder/static/xterm-old.css
#	./opt/edgego/agent/agent/terminalfolder/static/xterm-old.js
#	./opt/edgego/agent/agent/terminalfolder/static/xterm.css
#	./opt/edgego/agent/agent/terminalfolder/static/xterm.js
#	./opt/edgego/agent/agent/terminalfolder/static/xterm.js.map
#	./opt/edgego/agent/agent/vnc_indicator					# python3 -m PyInstaller -F ../agent/vnc_indicator.py # or replaced by prebuilt is ubuntu 18.04
#	./opt/edgego/agent/cmd/
#	./opt/edgego/agent/cmd/devicego							# python3 -m PyInstaller -F ../cmd/devicego.py *** NOTE: Entry Point ***
#	./opt/edgego/agent/cmd/devicego.ini
#	./opt/edgego/agent/cmd/libEdgeGoMDNS_ARM.so				# cp devicegosdk/devicegosdk/devicegosdktools/libs/libEdgeGoMDNS_ARM.so edgegoagent/opt/edgego/agent/cmd/
#	./opt/edgego/agent/cmd/libEdgeGoMDNS_x86.so				# cp devicegosdk/devicegosdk/devicegosdktools/libs/libEdgeGoMDNS_x86.so edgegoagent/opt/edgego/agent/cmd/
#	./opt/edgego/agent/cmd/signature.devicego
#	./opt/edgego/agent/deploydata/
#	./opt/edgego/agent/deploydata/agent/
#	./opt/edgego/agent/deploydata/agent/install.sh
#	./opt/edgego/agent/deploydata/agent/installservice.sh
#	./opt/edgego/agent/deploydata/agent/prepare.sh
#	./opt/edgego/agent/deploydata/agent/uninstall.py
#	./opt/edgego/agent/deploydata/agent/uninstallservice.sh
#	./opt/edgego/agent/messaging/
#	./opt/edgego/agent/messaging/send/
#	./opt/edgego/agent/messaging/send/edgego-server/
#
#
# edgego upgrade:
#
#	./opt/
#	./opt/edgego/
#	./opt/edgego/agent/
#	./opt/edgego/agent/agent/
#	./opt/edgego/agent/agent/signature.upgrade
#	./opt/edgego/agent/agent/upgrade						# python3 -m PyInstaller -F ../agent/upgrade.py
#	./opt/edgego/agent/deploydata/
#	./opt/edgego/agent/deploydata/upgrade/
#	./opt/edgego/agent/deploydata/upgrade/installupgrade.sh
#	./opt/edgego/agent/deploydata/upgrade/installupgradeservice.sh
#	./opt/edgego/agent/deploydata/upgrade/uninstallupgradeservice.sh
#
#
# vnc service:
#
#	./opt/
#	./opt/edgego/
#	./opt/edgego/agent/
#	./opt/edgego/agent/.vnc/
#	./opt/edgego/agent/.vnc/pwd
#	./opt/edgego/agent/deploydata/
#	./opt/edgego/agent/deploydata/vnc/
#	./opt/edgego/agent/deploydata/vnc/installvnc.sh
#	./opt/edgego/agent/deploydata/vnc/installvncservice.sh
#	./opt/edgego/agent/deploydata/vnc/novnc.service
#	./opt/edgego/agent/deploydata/vnc/openssl.cnf
#	./opt/edgego/agent/deploydata/vnc/preparevnc.sh
#	./opt/edgego/agent/deploydata/vnc/uninstallvncservice.sh
#	./opt/noVNC/*											# wget https://github.com/novnc/noVNC/archive/refs/heads/master.zip
#	./opt/noVNC/utils/websockify/*							# wget https://github.com/novnc/websockify/archive/refs/heads/master.zip
#

S = "${WORKDIR}/git"

DEPENDS += " \
	python3-pyinstaller-native \
	python3-altgraph-native \
	python3-pyinstaller-hooks-contrib-native \
	python3-setuptools-native \
	python3-packaging-native \
	openssl-native \
"

RDEPENDS:${PN} += " \
	python3-flask \
	python3-flask-socketio \
	python3-pycryptodome \
	python3-cryptography \
	python3-pamela \
	python3-comtypes \
	python3-pycaw \
	python3-requests \
	python3-pyyaml \
	python3-zeroconf \
	python3-watchdog \
	python3-devicegosdk \
"

INSANE_SKIP:${PN} += "already-stripped file-rdeps"

do_compile () {
	# upgrade
	pyinstaller -F ${S}/agent/upgrade.py
}

SIGNKEY ?= "${S}/keys/private.pem"

do_sign () {
	# signed all the pyinstaller build binaries
	for fname in upgrade; do
		openssl dgst -sha256 -sign ${SIGNKEY} -passin pass:edgego -out ${S}/dist/${fname}.sha256 ${S}/dist/${fname}
		openssl base64 -in ${S}/dist/${fname}.sha256 -out ${S}/dist/signature.${fname}
	done
}
addtask sign before do_install after do_compile

do_install () {
	#
	# directories
	#
	install -d ${D}${base_prefix}/opt/edgego/agent/agent/
	install -d ${D}${base_prefix}/opt/edgego/agent/deploydata/upgrade/
	#
	# files
	#
	# upgrade
	install -m 0755 ${S}/dist/upgrade ${D}${base_prefix}/opt/edgego/agent/agent/upgrade
	install -m 0644 ${S}/dist/signature.upgrade ${D}${base_prefix}/opt/edgego/agent/agent/signature.upgrade

	# prerm / postinst scripts
	install -D ${S}/deploydata/linux/upgrade/* ${D}${base_prefix}/opt/edgego/agent/deploydata/upgrade/

	# systemd devgoupgrade.service
	if [ -f ${WORKDIR}/devgoupgrade.service ]; then
		install -d ${D}${systemd_unitdir}/system
		install -m 644 ${WORKDIR}/devgoupgrade.service ${D}${systemd_unitdir}/system/devgoupgrade.servicedevgoupgrade.service
		install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
		ln -sf ${systemd_unitdir}/system/devgoupgrade.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/devgoupgrade.service
	fi
}


pkg_prerm:${PN} () {
	/opt/edgego/agent/deploydata/upgrade/uninstallupgradeservice.sh
}

pkg_postinst_ontarget:${PN} () {
	/opt/edgego/agent/deploydata/upgrade/installupgrade.sh
}

FILES:${PN} = "${base_prefix}/opt/* ${systemd_unitdir}/system/* ${sysconfdir}/systemd/system/multi-user.target.wants/*"
