import sys
# sys.setrecursionlimit(10**6) 
input=sys.stdin.readline
t=int(input())
for t1 in range(t):
    n=int(input())
    l=list(map(int,input().split(" ")))
    if(l[0]+l[1]<=l[-1]):
        print(1,2,n)
    else:
        print(-1)