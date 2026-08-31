t=int(input())
for _ in range(t):
    n=int(input())
    l=[]
    c=0
    for i in range(n):
        x,y=[int(b) for b in input().split()]
        if len(l)==0:
            l.append([x,y])
            if x<y:
                c=1
        else:
            w=l.pop(0)
            p=w[0]
            q=w[1]
            if p==x :
                l.append([x,y])    
                if q==y:
                    continue
                else:
                    c+=1 
            elif x>p:
                l.append([x,y])    
                if x-p>=y-q and y>=q:
                    continue
                else:
                    c+=1 
                    
            else:
                l.append([x,y])    
                c+=1 
            
                
    if c==0:
        print('YES')
    else:
        print('NO')
            
            
            
    
        
        