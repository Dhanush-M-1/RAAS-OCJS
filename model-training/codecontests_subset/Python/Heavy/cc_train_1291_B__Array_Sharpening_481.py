import math, collections, sys
input = sys.stdin.readline
def fromleft(z, n):
    a = [i for i in z]
    prev = -1
    i = 0
    while i < n:
        if a[i] >= prev+1:
            a[i] = prev+1
            prev+=1
        else:
            break
        i+=1
    while i < n:
        if prev == 0:
            break
        if a[i] >= prev-1:
            a[i] = prev-1
        prev = a[i]
        i+=1
    return a
def fromright(z, n):
    a = [i for i in z]
    prev = -1
    i = n-1
    while i > -1:
        if a[i] >= prev+1:
            a[i] = prev+1
            prev+=1
        else:
            break
        i-=1
    while i > -1:
        if prev == 0:
            break
        if a[i] >= prev-1:
            a[i] = prev-1
        prev = a[i]
        i-=1
    return a
def check(z, n):
    i = 1
    while i < n and z[i] > z[i-1]:
        i+=1
    while i < n and z[i] < z[i-1]:
        i+=1
    return i == n
for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    z1 = fromleft(a, n)
    z2 = fromright(a, n)
    # print(z1, z2)
    if check(z1, n) or check(z2, n):
        print("Yes")
    else:
        print("No")