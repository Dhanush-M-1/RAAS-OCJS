T = int(input())
for _ in range(T):
    N = int(input())
    A = list(map(int,input().split()))
    a,b,c = A[0],A[1],A[-1]
    if a+b <= c:
        print(1,2,N)
    else:
        print(-1)
