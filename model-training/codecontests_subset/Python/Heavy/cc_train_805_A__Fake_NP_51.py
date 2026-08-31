d=[]
z=list(map(int,input().split()))
if z[0]==z[1]:
    print(z[0])
else:
    for i in range(2,700):
        c=0
        for o in range(1,i):
            if i%o==0 and o!=1 and o!=i:
                c+=1

        if c==0:
            d.append(i)
    f=[]

    if z[1]-z[0]<10:
        for i in range(z[0],z[1]+1):
            for o in d:
                if i%o==0:
                    f.append(o)
    else:
        for i in range(z[0],z[0]+10):
                for o in d:
                    if i%o==0:
                        f.append(o)
    s=[]
    for i in d:
        fe=f.count(i)
        s.append([fe,i])
        if fe==0:
            break
    s=max(s)
    print(s[1])





                


