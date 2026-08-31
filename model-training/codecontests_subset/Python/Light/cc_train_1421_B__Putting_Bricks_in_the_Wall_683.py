t=int(input())
for i in range(t):
    n=int(input())
    b=[]
    for j in range(n):
        s=input()
        b.append(s)
    p,q=int(b[0][1]),int(b[1][0])
    r,s=int(b[-1][-2]),int(b[-2][-1])
    ans=[]
    if p==q:
        if r==p:
            ans.append([n,n-1])
        if s==p:
            ans.append([n-1,n])

    elif r==s:
        if p==r:
            ans.append([1,2])
        if q==r:
            ans.append([2,1])

    else:
        ans.append([2,1])
        if r == p:
            ans.append([n, n - 1])
        if s == p:
            ans.append([n - 1, n])

    print(len(ans))
    for j in ans:
        print(*j)






