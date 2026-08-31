from sys import stdin
input=stdin.readline

def A():
    t=int(input())
    for _ in range(t):
        n=int(input())
        a=list(map(int,input().split()))
        a.sort()
        found=False
        if a[0]+a[1] <= a[n-1]: print(1,2,n)
        else: print(-1)
        

def B():
    t=int(input())
    for _ in range(t):
        print(0)

def C():
    t=int(input())
    for _ in range(t):
        print(0)

def D():
    t=int(input())
    for _ in range(t):
        print(0)

A()
