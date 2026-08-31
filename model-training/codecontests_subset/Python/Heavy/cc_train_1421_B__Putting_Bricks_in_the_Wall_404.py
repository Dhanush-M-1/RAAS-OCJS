t=int(input())
while(t>0):
    n=int(input())
    l=[[] for x in range(n)]
    for x in range(0,n):
        a=list(input())
        l[x].extend(a)
    l1=list(l)    
    v1=l[0][1]
    v2=l[1][0]
    w1=l[n-1][n-2]
    w2=l[n-2][n-1]
    ans=0
    a=[]
    if((v1=='0' and v2=='0') and (w1=='1' and w2=='1')):
        ans=0
    elif((v1=='1' and v2=='1') and (w1=='0' and w2=='0')):
        ans=0
    elif(v1=='1' and v2=='1'):
        if(w1!='0'):
            ans+=1
            a.append((n,n-1))
        if(w2!='0'):
            ans+=1
            a.append((n-1,n))    
    elif(v1=='0' and v2=='0'):
        if(w1!='1'):
            ans+=1
            a.append((n,n-1))
        if(w2!='1'):
            ans+=1
            a.append((n-1,n))       
            
    elif(w1=='1' and w2=='1'):
        if(v1!='0'):
            ans+=1
            a.append((1,2))
        if(v2!='0'):
            ans+=1
            a.append((2,1))    
    elif(w1=='0' and w2=='0'):
        if(v1!='1'):
            ans+=1
            a.append((1,2))
        if(v2!='1'):
            ans+=1
            a.append((2,1))    
            
    else:
        if(v1=='1'):
            ans+=1
            a.append((1,2))
        else:
            ans+=1
            a.append((2,1))
        if(w1=='0'):
            ans+=1
            a.append((n,n-1))
        else:
            ans+=1
            a.append((n-1,n))    
        
        
    print(ans)
    
    for x in a:
        
        print(x[0],x[1])
            
            
    t-=1


