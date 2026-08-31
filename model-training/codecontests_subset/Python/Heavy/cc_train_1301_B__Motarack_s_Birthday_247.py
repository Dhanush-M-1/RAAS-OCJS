from functools import reduce
import math

t = int(input())

for case in range(t):

    n = int(input())
    a = input()

    a = [int(i) for i in a.split(' ')]
    l = len(a)

    mn = 1000000001
    mx = -mn

    besto_k = besto_dif = 0
    for i in range(l):
        if i > 0 and a[i] == -1 and a[i-1] != -1:
            mn, mx = min(mn, a[i-1]), max(mx, a[i-1])  
        if i < l-1 and a[i] == -1 and a[i+1] != -1:
            mn, mx = min(mn, a[i+1]), max(mx, a[i+1])

    besto_k = (mx + mn) // 2

    for i in range(l):
        if a[i] == -1: 
            a[i] = besto_k
        if i>0:
            besto_dif = max(besto_dif, abs(a[i] - a[i-1]))
    
   
    print(besto_dif, besto_k)