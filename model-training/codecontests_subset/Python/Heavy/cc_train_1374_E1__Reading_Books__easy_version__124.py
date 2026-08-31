from sys import stdin, stdout
import heapq as hq
from collections import defaultdict

t = 1
for tc in range(t):
    n,k = list(map(int, stdin.readline().split()))
    lib=[]
    for nc in range(n):
        lib.append(tuple(map(int, stdin.readline().split())))
    libA=[]
    libB=[]
    libAB=[]

    for book in lib:
        if book[1]+book[2]==2:
            libAB.append(book)
        elif book[1]==1:
            libA.append(book)
        elif book[2]==1:
            libB.append(book)

    libA=sorted(libA,key=lambda x:x[0])
    libB = sorted(libB, key=lambda x: x[0])
    libAB = sorted(libAB, key=lambda x: x[0])
    res=0
    p1=0
    p2=0
    while k>0 and p1<len(libA) and p1<len(libB) and p2<len(libAB):
        if libA[p1][0]+libB[p1][0]<libAB[p2][0]:
            res+=libA[p1][0]+libB[p1][0]
            p1+=1
            k-=1
        else:
            res += libAB[p2][0]
            p2 += 1
            k -= 1

    while k>0 and p2<len(libAB):
        res += libAB[p2][0]
        p2 += 1
        k -= 1

    while k>0 and p1<len(libA) and p1<len(libB):
        res += libA[p1][0] + libB[p1][0]
        p1 += 1
        k -= 1

    if k>0:
        res=-1

    stdout.write(str(res))