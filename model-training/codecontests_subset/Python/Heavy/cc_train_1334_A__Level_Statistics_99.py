# -*- coding: utf-8 -*-
from sys import stdin, stdout


def read():
    x0 = stdin.readline().rstrip()
    return x0


def __main__():
    t = int(read())
    for t0 in range(t):
        n = int(read().strip())
        #n = int(input().strip())
        p0 = 0
        c0 = 0
        fl = True
        for n0 in range(n):
            p, c = map(int, read().split())
            if p-p0 < c-c0 or p < p0 or c < c0:
                fl = False
            p0 = p
            c0 = c

        #a = [int(a0) for a0 in read().split()]

        if fl:
            out = 'YES\n'
        else:
            out = 'NO\n'

        stdout.write(out)

    
__main__()