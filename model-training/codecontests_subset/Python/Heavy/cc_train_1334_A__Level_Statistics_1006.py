t=int(input())

for j in range(t):
    
    n=int(input())
    p=[]
    c=[]

    for i in range(n):
        x,y=input().split()
        p.append(int(x))
        c.append(int(y))

    g=0
    for i in range(0,n):
        for k in range(i,n):
            if(p[k]== p[i] and c[k]!=c[i]):
                g=1
        
            elif(p[k]-p[i]<c[k]-c[i]):
                g=1
    
            elif(p[k]<p[i]):
                g=1
        
            elif(c[k]<c[i]):
                g=1
        
            elif(p[i]<c[i]):
                g=1
            
    if(g==1):
        print("NO")
    else:
        print("YES")