n=int(input())
a=[]
b=[]
for k in input().split(" "):
    if int(k)%2==0:
        a.append(int(k))
    else:
        b.append(int(k))
        
u=len(a)
v=len(b)
a.sort()
b.sort()
        
        
ans=[]        
if u>v:
    
    if u-v<2:
        ans.append(0)
    elif u-v==2:
        ans.append(a[0])
    else:
        q=0
        for i in range(0,len(a)-1-len(b)):
            q=q+a[i]
        ans.append(q)    
    if v!=0:    
        if u-v<1:
            ans.append(0)
        elif u-v==1:
            ans.append(a[0])
        else:
            q=0
            for i in range(0,len(a)-len(b)):
                q=q+a[i]
            ans.append(q)     
        
elif u==v:
    ans.append(0)
    
else:
    if v-u<2:
        ans.append(0)
    elif v-u==2:
        ans.append(b[0])
    else:
        q=0
        for i in range(0,len(b)-1-len(a)):
            q=q+b[i]
        ans.append(q)    
    if u!=0:    
        if v-u<1:
            ans.append(0)
        elif v-u==1:
            ans.append(b[0])
        else:
            q=0
            for i in range(0,len(b)-len(a)):
                q=q+b[i]
            ans.append(q)        
print(min(ans))            
    
        
    