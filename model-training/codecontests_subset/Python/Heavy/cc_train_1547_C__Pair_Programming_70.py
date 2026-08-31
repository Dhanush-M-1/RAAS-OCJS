import sys
from os import path
import collections
from collections import defaultdict
import math

if path.exists('input.txt'):
    sys.stdin = open('input.txt', 'r')
    sys.stdout = open('output.txt', 'w')
t = int(sys.stdin.readline().rstrip())
p = -1
while t > 0:
    t -= 1
    o = input()
    k, n, m = map(int, sys.stdin.readline().rstrip().split())
    a = list(map(int, sys.stdin.readline().rstrip().split()))
    b = list(map(int, sys.stdin.readline().rstrip().split()))
    i = r = 0
    s = ''
    f = 0
    ans = []
    while True:
        if i < n and r < m:
            if a[i] == 0:
                ans.append(a[i])
                k += 1
                i += 1

            elif b[r] == 0:
                ans.append(b[r])
                k += 1
                r += 1

            elif a[i] <= k:
                ans.append(a[i])
                i += 1

            elif b[r] <= k:
                ans.append(b[r])
                r += 1

            else:
                f = 1
                print(p)
                break

        elif i < n and r >= m:
            if a[i] == 0:
                ans.append(a[i])
                k += 1
                i += 1

            elif a[i] <= k:
                ans.append(a[i])
                i += 1

            else:
                f = 1
                print(p)
                break

        elif r < m and i >= n:
            if b[r] == 0:
                ans.append(b[r])
                k += 1
                r += 1

            elif b[r] <= k:
                ans.append(b[r])
                r += 1

            else:
                f = 1
                print(p)
                break
        else:
            break
    if f == 0:
        for x in ans:
            print(x, end=" ")
        print()
