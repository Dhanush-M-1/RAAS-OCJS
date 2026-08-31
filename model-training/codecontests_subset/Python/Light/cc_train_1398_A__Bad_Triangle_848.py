t=int(input())
for i in range(t):
    n=int(input())
    L=list(map(int, input().split()))
    if L[0]+L[1]>L[n-1]:
        print(-1)
    else:
        print(1, 2, n)