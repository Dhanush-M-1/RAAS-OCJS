a=int(input())
for i in range(a):
    r=input()
    z=list(map(int,input().split()))
    t=[]
    for i in range(len(z)):
        if(z[i]==-1):
            if(i>0):
                if(z[i-1]!=-1):
                    
                    t.append(z[i-1])
            if(i<len(z)-1):
                if(z[i+1]!=-1):
                    
                    t.append(z[i+1])
    if(len(t)==0):
        k=0
    else:
        k=(max(t)+min(t))//2
    for i in range(len(z)):
        if(z[i]==-1):
            z[i]=k
    mini=0        
    for i in range(1,len(z)):
        if(abs(z[i]-z[i-1])>mini):
            mini=abs(z[i]-z[i-1])
    
    print(mini,k)        
        

        
