#!/usr/bin/env python3
import sys, math, itertools, heapq, collections, bisect, string, copy
input = lambda: sys.stdin.buffer.readline().rstrip().decode('utf-8')
sys.setrecursionlimit(10**8)
inf = float('inf')
mod = 10**9+7
ans = 0 ; count = 0; pro = 1


n=int(input())
def ranlen(s):
    ans=[]
    count=1
    n=len(s)
    i=1
    while i<n:
        if s[i]==s[i-1]:
            count+=1
        else:
            ans.append(count)
            count=1
        i+=1
    ans.append(count)
    # print(ans)
    return ans

def solve():
    n=int(input())
    n2=math.ceil(n/2)
    P=list(input().split())
    ra=ranlen(P)
    # print(ra)
    ra.reverse()
    m=len(ra)
    for i in range(m):
        if n2<=0:
            break
        else:
            n2-=ra[i]
            n-=ra[i]
    ra=ra[i:]
    ra.reverse()
    s0=ra[0]
    count=0
    m=len(ra)
    for i in range(1,m):
        count+=ra[i]
        if count>s0 and n-s0-count>s0:
            print(s0, count, n-s0-count)
            return
    print(0,0,0)


    # print(count,m,"debug")
    # print(*ra,"debug")
    # if count>=2 and m>=3:
    #     print(s0,ra[1],n-s0-ra[1])
    # else:
    #     print(0,0,0)
    

    





for i in range(n):
    solve()
