t = int(input())
for i in range(0 ,t):
    input() 
    A = list(map(lambda x: int(x), input().split()))
    A.sort()
    if A[0]+A[1] <= A[-1]:
        print(1, 2, len(A))
    else:
        print(-1)