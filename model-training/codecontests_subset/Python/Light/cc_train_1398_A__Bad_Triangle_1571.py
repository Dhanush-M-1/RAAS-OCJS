for T in range(int(input())):
    input()
    A = list(map(int,input().split()))
    if A[0]+A[1]<=A[-1]: print(1,2,len(A))
    else: print(-1)