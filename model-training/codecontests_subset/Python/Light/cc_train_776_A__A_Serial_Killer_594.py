a, b = input().split()
n = int(input())
ans = [(a, b)] + [list() for i in range(n)]
for i in range(1, n + 1):
    a, b = input().split()
    ans[i] = ans[i - 1][1 if ans[i - 1][0] == a else 0], b
[print(*i) for i in ans]