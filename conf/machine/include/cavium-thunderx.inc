# Cavium ThunderX defaults

require conf/machine/include/soc-family.inc
require conf/machine/include/tune-thunderx.inc

SOC_FAMILY = "cavium-thunderx"

# used by sysvinit_2

SERIAL_CONSOLE ?= "115200 ttyAMA0"

