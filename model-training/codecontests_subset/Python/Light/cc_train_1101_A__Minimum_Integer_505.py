q=int(input())
for i in range(q):
    a,r,m=map(int,input().split())
    k=2
    d=m
    if d<a:
        print(d)
    elif d>r:
        print(d)
    else:
        print(d*((r//d)+1))

