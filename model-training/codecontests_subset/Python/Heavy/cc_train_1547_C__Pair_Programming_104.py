t = int(input())
for i in range(t):
    a = input()
    k, n, m = [int(i) for i in input().split()]
    a = [int(i) for i in input().split()]
    b = [int(i) for i in input().split()]
    now = k
    i=0
    j=0
    ans = []
    while i<n or j<m:
        if i!=n:
            if a[i]==0:
                k+=1
                ans.append(0)
                i+=1
                continue
            elif k>=a[i]:
               ans.append(a[i])
               i+=1
               continue
        if j!=m:
            if b[j]==0:
                k+=1
                ans.append(0)
                j+=1
                continue
            elif k>=b[j]:
                ans.append(b[j])
                j+=1
                continue
        break
    if len(ans)< n+m:
        print(-1)
    else:
        for i in range(n+m):
            print(ans[i], end =' ')
        print()
