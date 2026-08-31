#!/usr/bin/env python3
# -*- coding: utf-8 -*-
n=int(input())
a=[int(x) for x in input().split()]
b=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
a.sort()
b.sort()
c.sort()
for i in range(n-1):
    if b[i]!=a[i]:
        print(a[i])
        break
else:print(a[-1])
for i in range(n-2):
    if c[i]!=b[i]:
        print(b[i])
        break
else:print(b[-1])

