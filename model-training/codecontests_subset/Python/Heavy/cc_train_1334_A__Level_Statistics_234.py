from sys import stdin
input=stdin.readline

def A():
    t=int(input())
    for _ in range(t):
        n=int(input())
        p,c=[0]*n,[0]*n
        succ=True
        for i in range(n):
            p[i],c[i]=map(int,input().split())
        if p[0]<c[0]: succ=False
        else:
            for i in range(1,n):
                if c[i]-c[i-1]>p[i]-p[i-1] or c[i]<c[i-1] or p[i]<p[i-1]:
                    succ=False
                    break
        if succ: print("YES")
        else: print("NO")
    return

def B():
    return

def C():
    return

def D():
    return

A()
