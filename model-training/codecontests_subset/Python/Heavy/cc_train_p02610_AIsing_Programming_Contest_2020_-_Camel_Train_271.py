import sys
input = sys.stdin.readline
import heapq
from operator import itemgetter

T=int(input())
for tests in range(T):
    N=int(input())
    C=[tuple(map(int,input().split())) for i in range(N)]

    ANS=0
    LEFT=[]
    RIGHT=[]
    
    for k,l,r in C:
        if l>r:
            ANS+=r
            LEFT.append((k,l-r))
        else:
            ANS+=l
            RIGHT.append((k,r-l))

    LEFT.sort(key=itemgetter(0),reverse=True)
    H=[]
    ind=0

    for i in range(N,0,-1):
        while ind<len(LEFT) and LEFT[ind][0]>=i:
            heapq.heappush(H,-LEFT[ind][1])
            ind+=1

        if H:
            ANS+=-heapq.heappop(H)

    RIGHT.sort(key=itemgetter(0))
    H=[]
    ind=0

    for i in range(N):
        while ind<len(RIGHT) and RIGHT[ind][0]<=i:
            heapq.heappush(H,-RIGHT[ind][1])
            ind+=1

        if H:
            ANS+=-heapq.heappop(H)

    print(ANS)