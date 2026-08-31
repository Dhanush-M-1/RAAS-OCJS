import sys,math
input=sys.stdin.readline
t=int(input())
for r in range(t):
    n = int(input())
    l = list(map(int,input().split()))
    a = l[0]
    b = l[1]
    c = l[n-1]
    if a+b > c and b+c>a and a+c>b:
        print(-1)
    else:
        print(1,2,n)