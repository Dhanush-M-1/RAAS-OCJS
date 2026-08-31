q=int(input())
x=[]
for i in range(q):
    l,r,d=input().split()
    l=int(l)
    r=int(r)
    d=int(d)
    if r-l<0:
        t=l
        l=r
        r=t
    if r<d or d<l:
        x.append(d)
    else:
        x.append(d*(int(r/d)+1))
for i in x:
    print(i)
    