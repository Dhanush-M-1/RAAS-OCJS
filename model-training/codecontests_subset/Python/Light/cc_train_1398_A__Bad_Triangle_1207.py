for _ in range(int(input())):
    n = int(input())
    A = list(map(int,input().split()))
    a = A[0]+A[1]
    if(A[-1]>=a):
        print(1,2,n)
    else:
        print("-1")
    