# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""


n,m = map(int,input().split())
Union = set()
for i in range(n):
    L = input().split()
    t = int(L[0])
    s = {int(L[i]) for i in range(1,t+1)}
    Union = Union | s
if Union == {i+1 for i in range(m)}:
    print('YES')
else:
    print('NO')



        