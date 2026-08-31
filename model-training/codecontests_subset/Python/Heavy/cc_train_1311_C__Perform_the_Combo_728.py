I=input
for _ in range(int(I())):
    n,m=map(int,I().split())
    s=list(I())
    p=list(map(int,I().split(' ')))
    ds=[]
    t=[]
    c=[]
    ans=[0 for i in range(26)]
    for i in range(n):
        c1 = c.copy()
        t1 = t.copy()
        try:
            ind=t.index(s[i])
        except ValueError:
            ind=-1
        if ind==-1:
            t.append(s[i])
            t1.append(s[i])
            c.append(1)
            c1.append(1)
        else:
            c1[ind]+=1
            c[ind]+=1
        ds.append([t1,c1,0])
    for i in p:
        ds[i-1][2]+=1
    ds[n-1][2]=1
    p.append(n)
    # print(ds)
    for i in set(p):
        for j in range(len(ds[i-1][0])):
            asc=ord(ds[i-1][0][j])-97
            v=ds[i-1][1][j]
            ans[asc]+=v*(ds[i-1][2])
    for i in ans:
        print(i,end=' ')