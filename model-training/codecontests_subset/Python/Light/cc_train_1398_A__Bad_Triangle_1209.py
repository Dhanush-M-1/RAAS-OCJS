def answer(n,A):
    if A[0]+A[1]>A[-1]:
        return [-1]
    else:
        return [1,2,n]

t=int(input())
for i in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    print(*answer(n,arr))