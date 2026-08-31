#created by Кама Пуля ёжыы
n,m=map(int,input().split())
l=[[] for i in range(n+1)]
for i in range(m) :
    a,b=map(int,input().split())
    l[a].append(b)
    l[b].append(a)

v=[-1]*(n+1)
l1=[]
l2=[]
for i in range(1,n+1) :
    if v[i]==-1 :
        g=[i]
        v[i]=1
        l1.append(i)
        while len(g)>0 :
            for x in l[g[0]] :
                if v[x]==-1 :
                    if v[g[0]]==1 :
                        v[x]=2
                        l2.append(x)
                        g.append(x)
                    else :
                        v[x]=1
                        l1.append(x)
                        g.append(x)
                else :
                    if v[x]==v[g[0]] :
                        print(-1)
                        exit()
            del(g[0])
print(len(l1))
print(*l1)
print(len(l2))
print(*l2)
                
                
            

    
