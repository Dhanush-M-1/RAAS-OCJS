# from __future__ import print_function,division
# range = xrange
import sys
input = sys.stdin.readline
# sys.setrecursionlimit(10**9)
from sys import stdin, stdout
from collections import defaultdict, Counter
M = 10**9+7

def main():
    for _ in range(int(input())):
        n,m = [int(s) for s in input().split()]
        l = [int(s) for s in input().split()]
        q = [int(s) for s in input().split()]
        s = sum(l)
        ma = -10**9-7
        curr = 0
        for i in range(n):
            curr+=l[i]
            ma = max(curr,ma)
        ans = [-1]*m
        qs = []
        for i in range(m):
            if q[i]>ma:
                if s<=0:
                    continue
                else:
                    w = ((q[i]-ma)//s)*s
                    ans[i] = n*((q[i]-ma)//s)
                    if w+ma<q[i]:
                        w+=s
                        ans[i]+=n
                    qs.append([q[i]-w,i])
            else:
                ans[i] = 0
                qs.append([q[i],i])
        qs.sort()
        j = 0
        curr = 0
        # print(ans)
        for i in range(n):
            curr+=l[i]
            while j<len(qs) and qs[j][0]<=curr:
                ans[qs[j][1]]+=i
                j+=1
        print(*ans)


if __name__== '__main__':
    main()