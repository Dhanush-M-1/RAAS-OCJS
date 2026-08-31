
n,k=map(int,input().split())
s=list(map(int,input().split()))
c=100000
for i in range(n):
    if(k%s[i]==0):
        if(c>k//s[i]):
            c=k//s[i]
print(c)        
        
