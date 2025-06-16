#!/bin/sh

for f in tests/*.xpp; do
    echo "Running $f"
    java Xint < "$f"
done

