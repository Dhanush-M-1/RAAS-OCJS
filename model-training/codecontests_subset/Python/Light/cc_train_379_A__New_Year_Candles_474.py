n,k=map(int,input().split())
q=0
w=n
r=0
while w>0:
    r=r+(w%k)
    if r>=k:
        z=r%k
        r=r//k
        q=q+r
        r=r+z
    w=w//k
    q=q+w
print(n+q)