t=int(input())

for _ in range(t):
    n=int(input())
    p=[];c=[]
    
    for i in range(n):
        p_i,c_i=map(int,input().split())
        p.append(p_i)
        c.append(c_i)
    
    dp=p[0];dc=c[0]
    
    if dp-dc<0:
        print("NO")
    
    else:  
        for i in range(1,n):
            if p[i]-dp<c[i]-dc:
                print("NO")
                break
            
            if p[i]-dp<0 or c[i]-dc<0:
                print("NO")
                break
            
            if dp-dc<0:
                print("NO")
                break
            
            dp=p[i]
            dc=c[i]
            
        else:
            print("YES")        