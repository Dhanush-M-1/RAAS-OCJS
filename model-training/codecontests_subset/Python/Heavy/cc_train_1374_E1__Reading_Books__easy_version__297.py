n,k = list(map(int,input().split()))
a11,a10,a01 = [],[],[]
c,d = 0,0
for i in range(n):
    t,a,b = list(map(int,input().split()))
    if a==1 and b==1:
        a11.append(t)
    elif a==1 and b==0:
        a10.append(t)
    elif a==0 and b==1:
        a01.append(t)
    c+=a
    d+=b
a11.sort()
a10.sort()
a01.sort()
if c>=k and d>=k:
    ans,f = 0,0
    p1,p2,p3 = 0,0,0
    s1 = 10**10
    s2 = 10**10
    if len(a11)>=k:
        po = sum(a11[:k])
        s1 = min(s1,po)
    if len(a10)>=k and len(a01)>=k:
        v1,v2 = sum(a10[:k]),sum(a01[:k])
        s2 = min(s2,v1+v2)
    for i in range(k):
        if p2<len(a10) and p3<len(a01):
            if p1<len(a11):
                x = a10[p2]
                y = a01[p3]
                z = a11[p1]
                if z<x+y:
                    p1+=1
                else:
                    p2+=1
                    p3+=1
                ans+=min(x+y,z)
            else:
                x = a10[p2]
                y = a01[p3]
                ans+=x+y
                p2+=1
                p3+=1
        else:
            if p1<len(a11):
                ans+=a11[p1]
                p1+=1
            else:
                f = 1
                break
    if f==1:
        print(-1)
    else:
        print(min(ans,s1,s2))
else:
    print(-1)