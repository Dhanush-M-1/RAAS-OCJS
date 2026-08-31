n,m=map(int,input().split())
A=list(map(int,input().split()))
A.sort()
ans=None
for i in range(len(A)-1,-1,-1):
    if m%A[i] ==0:
        ans=m//A[i]
        break
print(ans)    
    