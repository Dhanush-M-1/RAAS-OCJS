n=int(input())
res=[]
while n:
    l,r,d=map(int,input().split())
    if d<l:
        res.append(d)
    elif d>r:
        res.append(d)
    elif l<=d<=r:
        m=r%d
        if m==0:
            res.append(r+d)
        else:
            res.append(d*(r//d+1))
    n=n-1
for i in res:
    print(i)
