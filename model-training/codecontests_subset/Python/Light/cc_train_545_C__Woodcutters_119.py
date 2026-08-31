x,h=[],[]
n=int(input())
for i in range(n):
    arr=[int(x) for x in input().split()]
    xi,hi=arr[0],arr[1]
    x.append(xi)
    h.append(hi)
    
ans=2    
flag=0
for i in range(1,n-1):
    gap1=x[i]-x[i-1]
    gap2=x[i+1]-x[i]
    if(gap1>h[i]):
        ans+=1
    elif(gap2>h[i]):
        x[i]+=h[i]
        ans+=1
        flag=1
if(n==1):
    print(1)
else:    
    print(ans)  
#print(x)