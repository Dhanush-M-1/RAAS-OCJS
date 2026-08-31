n,k=map(int,input().split())
ar =list(map(int,input().split()))
i=n-1
ar.sort()
while(True):
    if k%ar[i]==0:
        break
    i-=1
    
print(k//ar[i])