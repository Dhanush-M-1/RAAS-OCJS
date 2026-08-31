tc=int(input())
for _ in range(tc):
    input()
    k,n,m=map(int,(input().split()))
    a=[int(x) for x in input().split()]
    b=[int(x) for x in input().split()]
    # a.sort()
    i,j,ans=0,0,[]
    
    while i<n or j<m:
        if i<n and a[i]==0:
            k+=1
            ans.append(a[i])
            i+=1
        elif j<m and b[j]==0:
            k+=1
            ans.append(b[j])
            j+=1
        elif i<n and a[i]<=k:
            ans.append(a[i])
            i+=1
        elif j<m and b[j]<=k:
            ans.append(b[j])
            j+=1
        else:
            break
    
    if len(ans)==n+m:
        print(*ans)
    else:
        print(-1)