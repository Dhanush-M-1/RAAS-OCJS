#!/usr/bin/env python
# coding=utf-8
# 817079

f = lambda: map(int, input().split())
n, k = f()
print(k // max(a for a in f() if not k % a))


