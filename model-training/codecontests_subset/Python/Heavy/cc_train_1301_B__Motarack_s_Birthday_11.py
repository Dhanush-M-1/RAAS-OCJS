"""
    Author : thekushalghosh
    Team   : CodeDiggers
"""
import sys,math
input = sys.stdin.readline
############ ---- USER DEFINED INPUT FUNCTIONS ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(s[:len(s) - 1])
def invr():
    return(map(int,input().split()))
################################################################
############ ---- THE ACTUAL CODE STARTS BELOW ---- ############
t = 1
t = inp()
for tt in range(t):
    n = inp()
    a = inlt()
    b = []
    a.append(a[-1] + 1)
    for i in range(len(a) - 1):
        if a[i] != a[i + 1]:
            b.append(a[i])
    a = list(b)
    if len(set(a)) == 1 and -1 in a:
        print(0,0)
        continue
    else:
        for i in range(len(a)):
            if a[i] != -1:
                break
        a = [a[i]] + a
        for i in range(len(a) - 1,-1,-1):
            if a[i] != -1:
                break
        a = a + [a[i]]
    k = 0
    kk = 9999999999999
    w = max(a[0],a[1])
    for i in range(1,len(a) - 1):
        if a[i] == -1:
            q = max(a[i + 1],a[i - 1]) - ((a[i + 1] + a[i - 1]) // 2)
            if q > k:
                k = q
                w = (a[i + 1] + a[i - 1]) // 2
    a.append(a[-1])
    k = 0
    w = min(w,w)
    b = list(a)
    for i in range(len(a) - 1):
        if a[i] == -1:
            a[i] = w
    for i in range(len(a) - 1):
        k = max(abs(a[i + 1] - a[i]),k)
    kk = 0
    a = list(b)
    qq = 999999999999
    ww = 0
    for i in range(1,len(a) - 1):
        if a[i] == -1:
            qq = min(qq,a[i + 1],a[i - 1])
            ww = max(ww,a[i + 1],a[i - 1])
    ww = (ww + qq) // 2
    for i in range(len(a) - 1):
        if a[i] == -1:
            a[i] = ww
    for i in range(len(a) - 1):
        kk = max(abs(a[i + 1] - a[i]),kk)
    if kk < k:
        print(kk,ww)
    else:
        print(k,w)