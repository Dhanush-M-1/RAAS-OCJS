n,m=map(int,input().split())
A=[list(map(int,input().split())) for i in range(n)]
B=[list(map(int,input().split())) for i in range(m)]
for a in A:
    m=float('Inf')
    p=0
    for i,b in enumerate(B):
        if m>abs(a[0]-b[0])+abs(a[1]-b[1]):
            m=abs(a[0]-b[0])+abs(a[1]-b[1])
            p=i+1
    print(p)