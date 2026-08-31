n=int(input())
l=list(map(int, input().split()))
e=[]
o=[]
for i in range(len(l)):
    if(l[i]%2==0):
        e.append(l[i])
    else:
        o.append(l[i])
ek=len(e)
ok=len(o)
if(ek==(ok+1) or (ok+1)==ek or ek==ok):
    print("0")
else:
    if(ek>ok):
        d=ek-ok-1
        sum=0
        for i in range(d):
            k=min(e)
            m=e.index(k)
            e.pop(m)
            sum+=k
        print(sum)
    else:
        d=ok-ek-1
        sum=0
        for i in range(d):
            k=min(o)
            m=o.index(k)
            o.pop(m)
            sum+=k
        print(sum)
