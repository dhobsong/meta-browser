require chromium-ozone-wayland-tarball.inc
require chromium-gn.inc

SRC_URI += " \
 file://0001-Fix-GCC-build-remove-constexpr-for-non-resolved-comp.patch \
 file://0001-OmniboxTextView-fix-gcc-error-for-structure-initiali.patch \
 file://0001-ScrollPaintPropertyNode-Rename-SnapContainerData-to-.patch \
 file://0001-Fix-a-GCC-error-about-undeclared-std-unique_ptr.patch \
 file://0001-ozone-wayland-Fix-fpermissive-problem-for-GCC.patch \
 file://oe-clang-fixes.patch \
 file://0001-Rotate-gcc-toolchain-s-build-flags.patch \
 file://aarch64-skia-build-fix-m71.patch;patchdir=third_party/skia \
 file://0001-Exclude-CRC32-define-for-the-Renesas-M3-board.patch \
 file://0001-ozone-wayland-Don-t-build-gbm_wrappers-without-gbm-u.patch \
 file://0001-Do-shift-steps-sepparately.patch;patchdir=third_party/skia \
 file://0001-fix-LR-register-in-crashpad.patch \
 file://0001-Workaround-gcc-bug-protected-within-this-context.patch \
 file://0001-Fix-constexpr-needed-for-in-class-initialization-of-.patch \
 file://0001-webrtc-Add-CBP-to-list-of-supported-H.264-profiles-f.patch \
"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += "\
        libxkbcommon \
        virtual/egl \
        wayland \
"

GN_ARGS += "\
        use_ozone=true \
        ozone_auto_platforms=false \
        ozone_platform_headless=true \
        ozone_platform_wayland=true \
        ozone_platform_x11=false \
        use_xkbcommon=true \
        use_system_libwayland=true \
        use_system_minigbm=true \
        use_wayland_gbm=false \
        use_v4l2_codec=true \
        use_v4lplugin=true \
        use_linux_v4l2_only=true \
"



# The chromium binary must always be started with those arguments.
CHROMIUM_EXTRA_ARGS_append = " --ozone-platform=wayland --in-process-gpu"

# http://errors.yoctoproject.org/Errors/Details/186958/
EXCLUDE_FROM_WORLD_libc-musl = "1"
