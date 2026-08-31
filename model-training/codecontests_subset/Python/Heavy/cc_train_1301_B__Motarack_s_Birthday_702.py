def absolute(A,m):
    maxi=0
    for i in range(1,len(A)):
        if A[i]>=0:
            if A[i-1]==-1:
                maxi=max(maxi,abs(A[i]-m))
            else:
                maxi=max(maxi,abs(A[i]-A[i-1]))
                
        else:
            if A[i-1]>=0:
                maxi=max(maxi,abs(A[i-1]-m))
                
        
    return maxi

def answer(n,A):
    l=0
    r=10**9
    ans=10**9
    k=0
    while r>=l:
        mid=(l+r)//2
        d1=absolute(A,mid-1)
        d2=absolute(A,mid)
        d3=absolute(A,mid+1)
        if d2<ans:
            ans=d2
            k=mid
        if d1>d3:
            l=mid+1
        else:
            r=mid-1
    
    return [ans,k]
  
t=int(input())
for i in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    print(*answer(n,arr))