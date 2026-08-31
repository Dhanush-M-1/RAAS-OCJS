for _ in range(int(input())):
    n = int(input())
    A = list(map(int,input().split()))
    if not A[n-1]>= A[0]+A[1]:
        print(-1)
    else:
        print(1,2,n)
