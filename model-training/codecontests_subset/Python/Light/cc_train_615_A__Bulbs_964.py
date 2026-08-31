def solve(t_id):
    n, m = map(int, input().split())
    d = {}
    for i in range(n):
        a = list(map(int, input().split()))
        for i in range(1, len(a)):
            d[a[i]] = 1
    print('YES' if len(d) == m else 'NO')
t = 1
#t = int(input())
for t_id in range(1, t + 1):
    solve(t_id)
    t -= 1