SUMMARY = "EdgeGo is a software platform for ADLINK distributed device management"
HOMEPAGE = "https://www.adlinktech.com/tw/News_23110814280423873"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
SRCSERVER = "git://GitLab.Adlinktech.com/SEC_IST_CROSS_TEAM/edgego-agent.git"
SRCBRANCH = "dev"
SRCOPTIONS = ";protocol=http"
SRCOPTIONS:append:private = ";user=${PRIVATE_USER}:${PRIVATE_TOKEN}"
SRCREV = "55dcfd56f507b47259d0d89c1d643535e5cbb108"
SRC_URI = "${SRCSERVER};branch=${SRCBRANCH}${SRCOPTIONS}"

SRC_URI += "file://devgoagent.service file://devgoupgrade.service \
  file://0002-Agent-terminal.py-SocketIO-use-async_mode-threading.patch \
"

RCONFLICTS:${PN} = "edgego-agent edgego-upgrade"

#
# bundle python scripts for edgego-agent only
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
	python3-terminal \
	python3-devicegosdk \
	python3-simple-websocket \
"
# 	scrot zlib1g-dev python3-gevent

INSANE_SKIP:${PN} += "already-stripped file-rdeps"

SYSTEM_SERVICE_RUN_AGENT ?= "python3 /opt/edgego/agent/agent/agent.py"
SYSTEM_SERVICE_RUN_UPGRADE ?= "python3 /opt/edgego/agent/agent/upgrade.py"

do_install () {
	#
	# directories
	#
	install -d ${D}${base_prefix}/opt/edgego/agent/agent/
	install -d ${D}${base_prefix}/opt/edgego/agent/agent/root/
	install -d ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/
	install -d ${D}${base_prefix}/opt/edgego/agent/agent/terminalfolder/static/
	install -d ${D}${base_prefix}/opt/edgego/agent/cmd/
	install -d ${D}${base_prefix}/opt/edgego/agent/deploydata/agent/
	install -d ${D}${base_prefix}/opt/edgego/agent/deploydata/upgrade/

	#
	# files
	#
	install -m 0644 ${S}/Readme.txt ${D}${base_prefix}/opt/edgego/agent/Readme.txt
	#
	# agent
	#
	install -m 0755 ${S}/agent/agent.py ${D}${base_prefix}/opt/edgego/agent/agent/agent.py
	install -m 0644 ${S}/agent/agent.ini ${D}${base_prefix}/opt/edgego/agent/agent/agent.ini
	# scheduler
	install -m 0755 ${S}/agent/scheduler/cpu.py ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/cpu.py
	install -m 0755 ${S}/agent/scheduler/hdd.py ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/hdd.py
	install -m 0755 ${S}/agent/scheduler/heartbeat.py ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/heartbeat.py
	install -m 0755 ${S}/agent/scheduler/mem.py ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/mem.py
	install -m 0755 ${S}/agent/scheduler/network.py ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/network.py
	install -m 0644 ${S}/agent/scheduler/scheduler.ini ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/scheduler.ini
	# scheduler - not pyinstalled
	install -m 0755 ${S}/agent/scheduler/cputemp.py ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/cputemp.py
	install -m 0755 ${S}/agent/scheduler/gmail.py ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/gmail.py
	install -m 0755 ${S}/agent/scheduler/monitorprocess.py ${D}${base_prefix}/opt/edgego/agent/agent/scheduler/monitorprocess.py
	# terminal
	install -m 0755 ${S}/agent/terminal.py ${D}${base_prefix}/opt/edgego/agent/agent/terminal.py
	install -D ${S}/agent/terminalfolder/static/* ${D}${base_prefix}/opt/edgego/agent/agent/terminalfolder/static/
	# vnc_indicator
	install -m 0755 ${S}/agent/vnc_indicator.py ${D}${base_prefix}/opt/edgego/agent/agent/vnc_indicator.py
	# upgrade
	install -m 0755 ${S}/agent/upgrade.py ${D}${base_prefix}/opt/edgego/agent/agent/upgrade.py

	#
	# cmd/devicego
	#
	install -m 0755 ${S}/cmd/devicego.py ${D}${base_prefix}/opt/edgego/agent/cmd/devicego.py
	install -m 0755 ${S}/cmd/devicego.ini ${D}${base_prefix}/opt/edgego/agent/cmd/devicego.ini
	# cmd/devicego - not pyinstalled
	install -m 0755 ${S}/cmd/autoonboard.py ${D}${base_prefix}/opt/edgego/agent/cmd/autoonboard.py

	# prerm / postinst scripts
	install -D ${S}/deploydata/linux/agent/* ${D}${base_prefix}/opt/edgego/agent/deploydata/agent/
	install -D ${S}/deploydata/linux/upgrade/* ${D}${base_prefix}/opt/edgego/agent/deploydata/upgrade/

	# systemd devgoagent.service
	if [ -f ${WORKDIR}/devgoagent.service ]; then
		install -d ${D}${systemd_unitdir}/system
		install -m 644 ${WORKDIR}/devgoagent.service ${D}${systemd_unitdir}/system/devgoagent.service
		sed -i "s,@SYSTEM_SERVICE_RUN@,${SYSTEM_SERVICE_RUN_AGENT},g" ${D}${systemd_unitdir}/system/devgoagent.service
		install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
		ln -sf ${systemd_unitdir}/system/devgoagent.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/devgoagent.service
	fi
	# systemd devgoupgrade.service
	if [ -f ${WORKDIR}/devgoupgrade.service ]; then
		install -d ${D}${systemd_unitdir}/system
		install -m 644 ${WORKDIR}/devgoupgrade.service ${D}${systemd_unitdir}/system/devgoupgrade.service
		sed -i "s,@SYSTEM_SERVICE_RUN@,${SYSTEM_SERVICE_RUN_UPGRADE},g" ${D}${systemd_unitdir}/system/devgoupgrade.service
		install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
		ln -sf ${systemd_unitdir}/system/devgoupgrade.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/devgoupgrade.service
	fi
}

FILES:${PN} = "${base_prefix}/opt/* ${systemd_unitdir}/system/* ${sysconfdir}/systemd/system/multi-user.target.wants/*"
