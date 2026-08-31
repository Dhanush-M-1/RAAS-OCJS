def check(l,s,c):
    if l[0][1]==l[1][0]:
        x=l[0][1]
        a=l[n-1][n-2]
        b=l[n-2][n-1]
        if a==x:
            c=c+1
            s.append([n,n-1])
        if b==x:
            c=c+1
            s.append([n-1,n])
        print(c)
        for i in s:
            print(*i)
        return
    a=l[n-1][n-2]
    b=l[n-2][n-1]
    x,y=l[0][1],l[1][0]
    if a==b:
        z=a
        if x==a:
            c=c+1
            s.append([1,2])
        else:
            c=c+1
            s.append([2,1])
    else:
        c=c+1
        s.append([1,2])
        x=1-int(x)
        if int(a)==x:
            c=c+1
            s.append([n,n-1])
        else:
            c=c+1
            s.append([n-1,n])
    print(c)
    for i in s:
        print(*i)
for _ in range(int(input())):
    n=int(input())
    l=[]
    for i in range(n):
        k=list(input())
        l.append(k)
    s=[]
    c=0
    check(l,s,c)
    
    
        
            
    
        
        
    
    
        
    
        
                
                
    