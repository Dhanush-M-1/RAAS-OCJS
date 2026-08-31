t=int(input())
for i in range(t):
    n=int(input())
    a=[]
    for i in range(n):
        b=[]
        p,c=input().split()
        p=int(p)
        c=int(c)
        b.append(p)
        b.append(c)
        a.append(b)
     
    d=-1
    
    for j in range(n):
        e=a[j][0]
        f=a[j][1]
        if a[j][0]<a[j][1] :
            d=j
            break
        if j<n-1:
            diff1=a[j+1][0]-e
            diff2=a[j+1][1]-f
            if e>a[j+1][0] or f>a[j+1][1] or diff1<diff2:
                d=j
    if d==-1:
        print('YES')
    else:
        print('NO')
        
     