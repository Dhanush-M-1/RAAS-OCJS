n=int(input())
l=list(map(int,input().split()))
lo=[]
le=[]
no=0
ne=0
for j in range(n):
    if l[j]%2==0:
        le.append(l[j])
        ne+=1
    else:
        lo.append(l[j])
        no+=1
lo.sort(reverse=True)
le.sort(reverse=True)
if no-ne==1 or no-ne==-1 or no-ne==0:
    print(0)
else:
    s=sum(l)
    if ne>no:
        s=s-sum(lo)
        for j in range(no+1):
            s=s-le[j]
        print(s)
    else:
        s=s-sum(le)
        for j in range(ne+1):
            s=s-lo[j]
        print(s)