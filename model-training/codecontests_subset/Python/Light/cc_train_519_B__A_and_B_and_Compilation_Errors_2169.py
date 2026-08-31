# -*- coding: utf-8 -*-
"""
Created on Sat Jul 18 01:47:37 2020

@author: thiva
"""


n = int(input())
A = [int(s) for s in input().split()]
B = [int(s) for s in input().split()] + [1000000001]
C = [int(s) for s in input().split()] + [1000000001]
A.sort()
B.sort()
C.sort()

for i in range(n):
    if(A[i] != B[i]):
        ans_1 = A[i]
        break

for i in range(n-1):
    if(B[i] != C[i]):
        ans_2 = B[i]
        break

print(ans_1, ans_2)