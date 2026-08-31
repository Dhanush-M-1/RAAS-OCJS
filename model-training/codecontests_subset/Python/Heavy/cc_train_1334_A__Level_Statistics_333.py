#!/usr/bin/env python3
import io, os

input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

def get_str():
    return input().decode().strip()

def rint():
    return map(int, input().split())

def oint():
    return int(input())

T = oint()

for _ in range(T):
    n = oint()
    prev = [0,0]
    ok = 1
    for i in range(n):
        cur = list(rint())
        diffp = cur[0] - prev[0]
        diffl = cur[1] - prev[1]
        if diffp < 0 or diffl < 0:
            ok = 0
        if diffp < diffl:
            ok = 0
        prev[0], prev[1] = cur[0], cur[1]
    if ok == 0:
        print("NO")
    else:
        print("YES")
        