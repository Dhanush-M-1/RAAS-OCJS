N,M=map(int,input().split())
MOD=10**9+7
p,q,n=0,1,1
for _ in range(M):
    a=int(input())
    while n<=a:
        p,q=q,p+q
        n+=1
    q=0
while n<=N:
    p,q=q,p+q
    n+=1

print(q%MOD)