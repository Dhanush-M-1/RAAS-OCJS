t=int(input())
while t>0:
    l,r,d=map(int,input().split())
    if d<l:
        print(d)
    else:
        c=r//d
        print(d*(c+1))
    t=t-1
