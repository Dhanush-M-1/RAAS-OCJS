n, k = map(int, input().split())
al=[];bob=[];both=[]
for i in range(n):
    a,b,c= map(int, input().split())
    if(b==1 and c==1):
        both.append(a)
    elif(b==1):
        al.append(a)
    elif(c==1):
        bob.append(a)
tp=len(both)
la=len(al)
ob=len(bob)
a=la+tp
b=ob+tp
if(a<k or b<k):
    print("-1")
else:
    both.sort()
    al.sort()
    bob.sort()
    ans=0
    c=0;d=0
    for i in range(k):
        z=20001
        m=20001
        if(c<tp):
            z=both[c]
        if(d<la and d<ob):
            m=(al[d]+bob[d])
        if(z<m):
            ans+=z
            c+=1
        else:
            ans+=m
            d+=1
    print(ans)