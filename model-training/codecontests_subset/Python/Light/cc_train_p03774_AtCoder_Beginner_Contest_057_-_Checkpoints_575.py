n,m=map(int,input().split())
s=[list(map(int,input().split())) for _ in range(n)]
p=[list(map(int,input().split())) for _ in range(m)]
for a,b in s:
    k=float('inf')
    f=0
    for i,(c,d) in enumerate(p,start=1):
        t=abs(a-c)+abs(b-d)
        if k>t:
            k=t
            f=i
    print(f)
