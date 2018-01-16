SUMMARY = "Open Content Decryption Module."
HOMEPAGE = "https://www.fokus.fraunhofer.de/en"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea83f8bc099c40bde8c4f2441a6eb40b"

DEPENDS = "glib-2.0"
DEPENDS_append_libc-musl = " libtirpc"
CPPFLAGS_append_libc-musl = " -I${STAGING_INCDIR}/tirpc"
CXXFLAGS_append_libc-musl = " -I${STAGING_INCDIR}/tirpc"
CFLAGS_append_libc-musl = " -I${STAGING_INCDIR}/tirpc"
LDFLAGS_append_libc-musl = " -ltirpc"

SRCREV = "cd196589298de083fa996c7fbc568b3052798a8c"

PV = "1.0.gitr${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/psivasubramanian/open-content-decryption-module;branch=patch-2"
CFLAGS_append = " -DWPE=1"
CPPFLAGS_append = " -DWPE=1"
CXXFLAGS_append = " -DWPE=1"

CXXFLAGS += "-Wno-narrowing"

do_compile_prepend() {
        mkdir -p ${S}/src/browser/wpe/test/bin
}

do_install(){
        install -d ${D}${libdir}
        install -m 0755 ${B}/src/browser/wpe/lib/libocdm.so ${D}${libdir}
}

do_package_qa(){
}

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"

PARALLEL_MAKE = ""
