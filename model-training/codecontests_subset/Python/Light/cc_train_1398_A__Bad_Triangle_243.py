#!/usr/bin/env python3
import io
import os
import sys

input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

def prdbg(*args, **kwargs):
    print(*args, **kwargs)
    pass

def get_str():
    return input().decode().strip()

def rint():
    return map(int, input().split())

def oint():
    return int(input())

t = oint()

for _ in range(t):
    n = oint()
    a = list(rint())
    b = a[0] + a[1]
    for i in range(n-1, 1, -1):
        if a[i] >= b:
            print(1, 2, i+1)
            break
    else:
        print(-1)
