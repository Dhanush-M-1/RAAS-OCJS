def fun(a, n):
    if a[0] + a[1] <= a[-1]:
        return [1, 2, n]
        
    return [-1]


for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    print(*fun(a,n))
