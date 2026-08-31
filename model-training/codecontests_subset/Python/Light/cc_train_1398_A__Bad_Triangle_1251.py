T = int(input())
for t in range(T):
    n = int(input())
    a = list(map(int, input().split()))
    # for i in range(n):
    #     for j in range(i+1,n):
    #         for k in range(n-1,j):
    #             if a[i] + a[j] <= a[k]:
    if a[0] + a[1] <= a[n-1]:
        print(1,2,n)
    else:
        print(-1)

