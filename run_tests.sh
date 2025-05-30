#!/bin/sh

for f in tests/*.l1; do
    echo "Running $f"
    java L1int < "$f"
done

