rm -rf _mirror temp
git clone https://github.com/surfstudio/Core-ui _mirror
git clone --single-branch --branch dev/G-0.5.0 https://gitlab.com/surfstudio/projects/standard/android-standard temp
./gradlew deployToMirror -Pcomponent=core-ui -Pcommit=34b1f0aa3a3991423a4e79df58a2465de0c425da -PmirrorDir=_mirror -PdepthLimit=100 -PsearchLimit=100 -PmirrorUrl=https://github.com/surfstudio/Core-ui
