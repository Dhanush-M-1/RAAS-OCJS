for _ in range(int(input())):
    n=int(input())
    L=[int(x) for x in input().strip().split(" ")]
    mini,maxi=float('inf'),0

    for i in range(n):
        if L[i]==-1:
            if i>0 and L[i-1]!=-1:
                mini=min(mini,L[i-1])
                maxi=max(maxi,L[i-1])
            if i<n-1 and L[i+1]!=-1:
                mini=min(mini,L[i+1])
                maxi=max(maxi,L[i+1])

    if mini==float('inf'): mini=0
    k=(maxi+mini)//2
    L=[k if x==-1 else x for x in L]
    m=0
    for i in range(1,n):
        m=max(m,abs(L[i]-L[i-1]))
    print(m,k)
