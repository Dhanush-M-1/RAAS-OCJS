t=int(input())
for _ in range(t):
    n=int(input())
    l=[]
    for i in range(n):
        l.append(input())
    a,b=l[0][1],l[1][0]
    x,y=l[n-1][n-2],l[n-2][n-1]
    if a==b:
        ans=0
        k=[]
        if x==a:
            k.append([n-1+1,n-2+1])
            ans+=1
        if y==a:
            k.append([n-2+1,n-1+1])
            ans+=1
        print(ans)
        for i in k:
            print(*i)
    elif x==y:
        ans=0
        k=[]
        if x==a:
            k.append([1,2])
            ans+=1
        if y==b:
            k.append([2,1])
            ans+=1
        print(ans)
        for i in k:
            print(*i)
    else:
        ans=0
        k=[]
        if a=='0':
            k.append([1,2])
            ans+=1
        if b=='0':
            k.append([2,1])
            ans+=1
        if x=='1':
            k.append([n-1+1,n-2+1])
            ans+=1
        if y=='1':
            k.append([n-2+1,n-1+1])
            ans+=1
        print(ans)
        for i in k:
            print(*i)
