#!/usr/bin/env bash

pushd /opt/android-ndk
wget -q https://dl.google.com/android/repository/android-ndk-r12b-linux-x86_64.zip
unzip -q android-ndk-r12b-linux-x86_64.zip
mv android-ndk-r12b r12b
rm android-ndk-r12b-linux-x86_64.zip
popd