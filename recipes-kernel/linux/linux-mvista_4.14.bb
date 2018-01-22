KBRANCH ?= "${MV_KERNEL_BRANCH}"

require recipes-kernel/linux/linux-yocto.inc

SRCREV_machine ?= "${MV_KERNEL_BRANCH}"
#SRCREV_meta ?= "eda4d18ce4b259c84ccd5c249c3dc5958c16928c"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


S = "${WORKDIR}/git"

LINUX_VERSION = "4.14.3"
PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "${MV_KERNEL_TREE};branch=${KBRANCH};name=machine"
SRC_URI += "file://defconfig"

KCONF_BSP_AUDIT_LEVEL = "0"
COMPATIBLE_MACHINE_cavium-thunderx = "cavium-thunderx"

# Signing applications require openssl-native
DEPENDS += "openssl-native"
EXTRA_OEMAKE += "HOSTCC='gcc -I${STAGING_INCDIR_NATIVE} -L${STAGING_DIR_NATIVE}/lib -Wl,-rpath,${STAGING_DIR_NATIVE}/lib'"

KERNEL_FEATURES_remove ="features/debug/printk.scc"
