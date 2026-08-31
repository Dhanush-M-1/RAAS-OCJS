t=int(input())
for _ in range(t):
    n=int(input())
    A=list(map(int,input().split()))
    L=[]
    m=0
    now=A[0]
    for a in A[1:]:
        if now==-1:
            if a!=-1:
                L.append(a)
                now=a
        else:
            if a==-1:
                L.append(now)
                now=-1
            else:
                m=max(m,abs(a-now))
                now=a
    L.sort()
    if L:
        k=(L[-1]+L[0])//2
        m=max(m,L[-1]-k)
    else:
        k=0
        m=0
    print(m,k)