n=int(input())
X=[]
H=[]
for i in range(n):
    x,h=[int(i) for i in input().split()]
    X.append(x)
    H.append(h)
ans=1
last=X[0]
for i in range(1,n-1):
    if X[i]-H[i]>last:
        ans+=1
        last=X[i]
    elif X[i]+H[i]< X[i+1]:
        ans+=1
        last=X[i]+H[i]
    else:
        last=X[i]
if n>1:
    ans+=1
print(ans)
        
        
        
    