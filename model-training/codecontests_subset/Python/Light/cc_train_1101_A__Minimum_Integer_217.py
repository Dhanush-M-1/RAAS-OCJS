q=int(input())
def f(l,r,d):
    if d<l or d>r:return d
    return d*(int(r/d)+1)
for k in range(q):
    l,r,d=map(int,input().split())
    print(f(l,r,d))