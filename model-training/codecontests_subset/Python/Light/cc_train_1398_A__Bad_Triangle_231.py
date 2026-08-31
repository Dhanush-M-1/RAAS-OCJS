# [int(s) for s in input().split()]
# int(input())
# input()

T = int(input())
for t in range(1,T+1):
    N = int(input())
    A = [int(s) for s in input().split()]
    if A[0] + A[1] <= A[-1]:
        print(1,2,N)
    else:
        print(-1)