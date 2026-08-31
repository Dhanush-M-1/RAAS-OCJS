from collections import defaultdict
from math import *


t = int(input())

for k in range(t):
    n = int(input())
    a = []
    for i in range(n):
        a.append([int(el) for el in input().split()])
    #print(a)
    bad = False
    if a[0][1] > a[0][0]:
        bad = True
    for i in range(1, n):
        if a[i][0] < a[i][1]:
            bad = True
            #print(1)
        if a[i][0] < a[i-1][0] or a[i][1] < a[i-1][1]:
            bad = True
            #print(2)
        if a[i][1] - a[i-1][1] > a[i][0] - a[i-1][0]:
            bad = True
            #print(3)

    if bad:
        print("NO")
    else:
        print("YES")

