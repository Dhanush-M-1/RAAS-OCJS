# import sys
# input=sys.stdin.readline
t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    if a[0]+a[1]<=a[-1]:
        print(1,2,n)
    elif a[0]+a[-2]<=a[-1]:
        print(1,n-1,n)
    else:
        print(-1)