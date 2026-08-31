n,k=map(int,input().split())
c=[]
d=[]
e=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==0:
        c.append(t)
    elif b==1 and a==0:
        d.append(t)
    elif a==1 and b==1:
        e.append(t)

if (len(c)+len(e))<k or (len(d)+len(e))<k:
    print(-1)
else:
    c=sorted(c)
    d=sorted(d)
    e=sorted(e)

    l1=len(c)
    l2=len(d)
    l3=len(e)
    s=0
    i1=0
    i2=0
    i3=0
    while((i1+i3)<k or (i2+i3)<k):
        if i3<l3:
            if (i2 + i3) >= k and i1 < l1:
                if e[i3] <= c[i1]:
                    s += e[i3]
                    i3 += 1
                else:
                    s += c[i1]
                    i1 += 1
            elif (i1 + i3) >= k and i2 < l2:
                if e[i3] <= d[i2]:
                    s += e[i3]
                    i3 += 1
                else:
                    s += d[i2]
                    i2 += 1
            elif i1<l1 and i2<l2:
                if e[i3]<=(c[i1]+d[i2]):
                    s+=e[i3]
                    i3+=1
                else:
                    s+=(c[i1]+d[i2])
                    i1+=1
                    i2+=1


            else:
                s+=e[i3]
                i3+=1





        else:
            s+=(c[i1]+d[i2])
            i1+=1
            i2+=1
    print(s)




