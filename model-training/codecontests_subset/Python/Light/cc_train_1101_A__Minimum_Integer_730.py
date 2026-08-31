import sys
import bisect
input=sys.stdin.readline
t=int(input())
#t=1
mod=10**9+7
for _ in range(t):
    #n=int(input())
    l,r,d=map(int,input().split())
    #s=input()
    #l=list(map(int,input().split()))
    if l>d:
        print(1*d)
    else:
        x=r//d
        print((x+1)*d)