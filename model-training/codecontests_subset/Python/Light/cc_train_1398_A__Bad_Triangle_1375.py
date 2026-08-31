T=int(input())
for _ in range(T):
    N=int(input())
    A=list(map(int,input().split()))
    last=A[-1]
    if A[0]+A[1]<=last:
        print(1,2,N)
    else:
        print(-1)
