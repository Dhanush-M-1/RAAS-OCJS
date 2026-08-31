T = int(input())
for t in range(T):
    n = int(input())
    A = [int(i) for i in input().split()]
    if A[0] + A[1] > A[-1]:
        print(-1)
    else:
        print(1,2,n)