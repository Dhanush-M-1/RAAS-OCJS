#!/usr/bin/env python
from __future__ import division, print_function

import io
import os
import sys

if sys.version_info[0] < 3:
    from __builtin__ import xrange as range
    from cStringIO import StringIO
    from future_builtins import ascii, filter, hex, map, oct, zip
else:
    from io import BytesIO as StringIO

sys.stdout, stream = io.IOBase(), StringIO()
sys.stdout.flush = lambda: os.write(1, stream.getvalue()) and not stream.truncate(0) and stream.seek(0)
sys.stdout.write = stream.write if sys.version_info[0] < 3 else lambda s: stream.write(s.encode())

input, flush = sys.stdin.readline, sys.stdout.flush
input = StringIO(os.read(0, os.fstat(0).st_size)).readline


def main():
    n = int(input())
    a = list(map(int, input().split()))
    p = [0, 0]

    e = []
    o = []

    for i in a:
        p[i & 1] += 1
        if i & 1:
            o.append(i)
        else:
            e.append(i)

    e.sort(reverse=True)
    o.sort(reverse=True)

    if abs(p[0] - p[1]) < 2:
        print(0)
    else:
        if p[0] < p[1]:
            d = sum(e) + sum(o[:p[0] + 1])
        else:
            d = sum(o) + sum(e[:p[1] + 1])

        print(sum(a) - d)


if __name__ == '__main__':
    main()
