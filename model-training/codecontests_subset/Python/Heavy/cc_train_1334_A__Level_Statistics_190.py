from math import *
from bisect import bisect_left, bisect_right
from sys import stdin, stdout
from collections import Counter
input = lambda: stdin.readline().strip()
print = stdout.write

T = int(input())
for _ in range(T):
    n = int(input())
    s1, s2 = [], []
    for i in range(n):
        a, b = map(int, input().split())
        s1.append(a)
        s2.append(b)
    for i in range(n):
        if s2[i]>s1[i]:
            print('NO\n')
            break
    else:
        for i in range(n-1):
            if s1[i+1]<s1[i] or s2[i+1]<s2[i]:
                print('NO\n')
                break
        else:
            for i in range(n-1):
                if (s1[i+1]-s1[i])<(s2[i+1]-s2[i]):
                    print('NO\n')
                    break
            else:
                print('YES\n')
