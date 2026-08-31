for _ in range(int(input())):
    n = int(input())
    a = [int(i) for i in input().split()]
    ans = [-1]
    a.sort()
    if a[0] + a[1] <= a[n-1]:
        ans = [1,2,n]
    print(*ans)