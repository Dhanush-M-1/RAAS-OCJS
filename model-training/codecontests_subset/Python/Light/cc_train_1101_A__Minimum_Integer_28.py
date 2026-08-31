q=int(input())
for i in range(q):
    l,r,d=map(int,input().split())
    k=1
    x=0
    if (d<l)or(d>r):
        print(d)
    else:
        kol=r//d+1
        print(d*kol)
            
