def solve(n,a):
    i = 0
    j = 1
    for idx in range(2, n):
        c = a[idx]
        if c+a[i] <= a[j] or c + a[j] <= a[i] or a[i] + a[j] <= c:
            c = idx
            print(i+1,j+1,idx+1)
            return
    print(-1)
        

t = int(input())
for test in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    solve(n,a)
