import sys
input=sys.stdin.readline

T=int(input())
for _ in range(T):
    N=int(input())
    A=list(map(int,input().split()))
    a=A[0]
    b=A[1]
    c=A[N-1]
    
    if (a + b <= c) or (a + c <= b) or (b + c <= a) : 
        print(1,2,N)
    else:
        print(-1)
