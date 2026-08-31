import sys
import math

s = input()
n = int(input())
Flag1 = Flag2 = False
for i in range(n):
    tmps = input()
    if tmps == s:
        print('YES')
        exit()
    if tmps[1] == s[0]:
        Flag1 = True
    if tmps[0] == s[1]:
        Flag2 = True
if Flag1 and Flag2:
    print('YES')
else:
    print('NO')