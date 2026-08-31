t=int(input())

for i in range(t):
    _=input()
    k,n,m=map(int,input().split())
    i=0
    j=0
    res=[]

    arr1=list(map(int,input().split()))
    arr2=list(map(int,input().split()))

    while i<n or j<m:
        if i<n and arr1[i]==0:
            k+=1
            i+=1
            res.append(0)
        
        elif j<m and arr2[j]==0:
            k+=1
            j+=1
            res.append(0)
        
        elif i<n and arr1[i]<=k:
            res.append(arr1[i])
            i+=1
        
        elif j<m and arr2[j]<=k:
            res.append(arr2[j])
            j+=1
        
        else:
            res=[-1]
            break
    
    print(*res)

