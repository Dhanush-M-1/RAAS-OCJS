# -*- coding: utf-8 -*-

a, b = map(int, input().split())

h = 0
aa = 0

while a:
    h += a
    aa += a
    a = aa // b
    aa = aa % b
 
print(h)