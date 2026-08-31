for _ in  range(int(input())):
    a,b=input().split()
    la=len(a)
    lb=len(b)
    dd=[]
    for i in range(la):
        dd.append([a[i],i])
    dd.sort()
   # print(dd)
    i=0
    c=0
    r=""
    di={i:i for i in range(la)}
    while i<la and c<1:
        if dd[i][1]!=i:
            for j in range(la-1,-1,-1):
                if a[j]==dd[i][0]:
                    gg=j
                    break
            di[gg]=i
            di[i]=gg
            c+=1
        i+=1
    for i in range(la):
        r+=a[di[i]]
    if la>=lb and r<b:
        print(r)
    elif la<lb and r<=b:
        print(r)
    else:
        print("---")
